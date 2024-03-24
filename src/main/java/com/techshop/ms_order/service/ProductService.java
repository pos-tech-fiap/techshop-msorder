package com.techshop.ms_order.service;

import com.techshop.ms_order.useCase.DTO.PaymentDTO;
import com.techshop.ms_order.useCase.DTO.ProductDTO;
import com.techshop.ms_order.useCase.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final WebClient webClient;
    private final PaymentService paymentService;
    String baseUrl = "http://localhost:8084";
    String baseUrlMock = "https://65fe0693b2a18489b385b835.mockapi.io/products/";

    @Autowired
    public ProductService(WebClient.Builder webClientBuilder, PaymentService paymentService) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
        this.paymentService = paymentService;
    }

    public Mono<ProductDTO> getProduct(String productId) {
        return this.webClient.get()
                .uri("/products/{id}", productId)
                .retrieve()
                .bodyToMono(ProductDTO.class);
    }
    public Mono<ProductDTO> processPaymentAndDeductQuantity(String productId, Orders order, PaymentDTO paymentDTO) {
        return getProduct(productId)
                .flatMap(product -> paymentService.postPayment(paymentDTO)
                        .flatMap(updatedPayment -> {
                            if (product.getQuantity() >= order.getQuantity()) {
                                product.setQuantity(product.getQuantity() - order.getQuantity());
                                return updateProductQuantity(product);
                            } else {
                                return Mono.error(new RuntimeException("Insufficient quantity available."));
                            }
                        }));
    }
    public Mono<ProductDTO> updateProductQuantity(ProductDTO product) {
        return this.webClient.put()
                .uri("/products/{id}", 1)
                .body(BodyInserters.fromValue(product))
                .retrieve()
                .bodyToMono(ProductDTO.class);
    }
}
