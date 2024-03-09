package com.techshop.ms_order.service;

import com.techshop.ms_order.repository.OrdersRepository;
import com.techshop.ms_order.useCase.DTO.OrdersDTO;
import com.techshop.ms_order.useCase.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    public Mono<Orders> save(OrdersDTO ordersDTO) {
        var order = new Orders(ordersDTO);
        return ordersRepository.save(order)
                .onErrorMap(e -> new RuntimeException("Failed to save order", e));
    }

    public Mono<Orders> getOrderById(String orderId) {
        return ordersRepository.findById(orderId)
                .switchIfEmpty(Mono.error(new RuntimeException("Order not found with ID: " + orderId)))
                .flatMap(order -> Mono.justOrEmpty(order.orElse(null)));
    }

    public Flux<Orders> findAll() {
        return ordersRepository.findAll().onErrorMap(e -> new RuntimeException("Failed to find orders", e));
    }

    public Mono<Void> delete(String orderId) {
        return ordersRepository.delete(orderId).onErrorMap(e -> new RuntimeException("Failed to delete order", e));
    }
}
