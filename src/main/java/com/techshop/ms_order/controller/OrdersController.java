package com.techshop.ms_order.controller;

import com.techshop.ms_order.service.OrdersService;
import com.techshop.ms_order.service.PaymentService;
import com.techshop.ms_order.service.ProductService;
import com.techshop.ms_order.useCase.DTO.OrdersDTO;
import com.techshop.ms_order.useCase.DTO.PaymentDTO;
import com.techshop.ms_order.useCase.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @PostMapping("/order")
    public Mono<ResponseEntity<Orders>> save(@RequestBody @Valid OrdersDTO ordersDTO) {

        return ordersService.save(ordersDTO)
                .map(saveOrder -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(saveOrder));
    }
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Orders>> getById(@PathVariable("id") String orderId) {
        return ordersService.getOrderById(orderId)
                .map(order -> ResponseEntity.ok().body(order))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public Mono<ResponseEntity<List<Orders>>> getAll() {
        return ordersService.findAll()
                .collectList()
                .map(orders -> {
                    if (!orders.isEmpty()) {
                        return ResponseEntity.ok().body(orders);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                });
    }
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable("id") String orderId) {
        return ordersService.delete(orderId)
                .map(saveOrder -> ResponseEntity.status(HttpStatus.OK)
                        .body(saveOrder));
    }
}
