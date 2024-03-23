package com.techshop.ms_order.service;

import com.techshop.ms_order.useCase.DTO.PaymentDTO;
import com.techshop.ms_order.useCase.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final WebClient webClient;
    String baseUrl = "https://localhost:8081";
    String baseUrlMock = "https://65fe0693b2a18489b385b835.mockapi.io/payments";

    @Autowired
    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(baseUrlMock).build();
    }

    public Mono<ProductDTO> postPayment(PaymentDTO paymentDTO) {
        return this.webClient.post()
                .uri("/payment")
                .body(BodyInserters.fromValue(paymentDTO))
                .retrieve()
                .bodyToMono(ProductDTO.class);
    }
}
