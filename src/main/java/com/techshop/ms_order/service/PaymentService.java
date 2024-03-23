package com.techshop.ms_order.service;

import com.techshop.ms_order.useCase.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PaymentService {
    private final WebClient webClient;
    String baseUrl = "https://localhost:8081";
    String baseUrlMock = "https://65fe0693b2a18489b385b835.mockapi.io/products";

    @Autowired
    public PaymentService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(baseUrlMock).build();
    }

    public Mono<ProductDTO> getProduct() {
        return this.webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToMono(ProductDTO.class);
    }
    public Mono<ProductDTO> updateProductQuantity(ProductDTO product) {
        return this.webClient.put()
                .uri("/products/{id}", product.productId)
                .body(BodyInserters.fromValue(product))
                .retrieve()
                .bodyToMono(ProductDTO.class);
    }
}
