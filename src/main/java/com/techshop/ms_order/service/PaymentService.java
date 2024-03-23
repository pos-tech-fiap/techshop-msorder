package com.techshop.ms_order.service;

import com.techshop.ms_order.useCase.DTO.PaymentDTO;
import com.techshop.ms_order.useCase.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PaymentService {
    private final WebClient webClient;
    String baseUrl = "https://localhost:8083";
    String baseUrlMock = "http://demo8072397.mockable.io/";

    @Autowired
    public PaymentService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    public Mono<PaymentDTO> postPayment(PaymentDTO payment) {
        return this.webClient.post()
                .uri("/payment")
                .body(BodyInserters.fromValue(payment))
                .retrieve()
                .bodyToMono(PaymentDTO.class);
    }
}
