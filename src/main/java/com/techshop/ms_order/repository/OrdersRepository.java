package com.techshop.ms_order.repository;

import com.techshop.ms_order.useCase.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
@Repository
public class OrdersRepository {
    @Autowired
    IOrdersRepository ordersRepository;

    public Mono<Orders> save(Orders orders){
        return ordersRepository.save(orders)
                .onErrorMap(e -> new RuntimeException("Failed to save order", e));
    }

    public Mono<Optional<Orders>> findById(String orderId){
        return ordersRepository.findById(orderId)
                .map(Optional::ofNullable)
                .switchIfEmpty(Mono.error(new RuntimeException("Order not found")));
    }

    public Flux<Orders> findAll(){
        return ordersRepository.findAll().onErrorMap(e -> new RuntimeException("Failed to find orders", e));
    }

    public Mono<Void> delete(String orderId){
        return ordersRepository.deleteById(orderId).onErrorMap(e -> new RuntimeException("Failed to delete order", e));
    }

}
