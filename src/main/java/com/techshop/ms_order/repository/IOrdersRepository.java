package com.techshop.ms_order.repository;

import com.techshop.ms_order.useCase.entity.Orders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IOrdersRepository extends ReactiveMongoRepository<Orders, String> {
    Mono<Orders> save(Orders orders);
    Flux<Orders> findAllBy(Pageable pagination);
}
