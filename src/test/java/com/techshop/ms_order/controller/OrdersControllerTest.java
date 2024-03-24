//package com.techshop.ms_order.controller;
//
//import com.techshop.ms_order.service.OrdersService;
//import com.techshop.ms_order.useCase.DTO.OrdersDTO;
//import com.techshop.ms_order.useCase.entity.Orders;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@AutoConfigureWebTestClient
//public class OrdersControllerTest {
//
//    @Mock
//    private OrdersService ordersService;
//
//    @InjectMocks
//    private OrdersController ordersController;
//
//    @Autowired
//    private WebTestClient webTestClient;
//
//
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
////    @Test
////    public void testSaveOrder() throws Exception {
////        OrdersDTO ordersDTO = new OrdersDTO("1", 5, "Flor da Silva", "flor@example.com", "Rua ABC, 123", "credit_card",  2.00,"PENDING");
////        Orders savedOrder = new Orders(ordersDTO);
////
////        when(ordersService.save(any(OrdersDTO.class))).thenReturn(Mono.just(savedOrder));
////
////        webTestClient.post()
////                .uri("/orders/order")
////                .contentType(MediaType.APPLICATION_JSON)
////                .bodyValue(ordersDTO)
////                .exchange()
////                .expectStatus().isCreated();
////    }
////
////    @Test
////    public void testGetOrderById() throws Exception {
////        OrdersDTO ordersDTO = new OrdersDTO("1", 5, "Flor da Silva", "flor@example.com", "Rua ABC, 123", "credit_card",  2.00,"PENDING");
////        Orders savedOrder = new Orders(ordersDTO);
////        String orderID = "65ecb34355b73c3abc3e3836";
////
////        when(ordersService.getOrderById(orderID)).thenReturn(Mono.just(savedOrder));
////
////        webTestClient.get()
////                .uri("/orders/{id}", orderID)
////                .exchange()
////                .expectStatus().isOk();
////    }
//
//    @Test
//    public void testGetAllOrders() throws Exception {
//        OrdersDTO ordersDTO = new OrdersDTO("1", 5, "Flor da Silva", "flor@example.com", "Rua ABC, 123", "credit_card",  2.00,"PENDING");
//        List<Orders> ordersList = Arrays.asList(
//                new Orders(ordersDTO),
//                new Orders(ordersDTO),
//                new Orders(ordersDTO)
//        );
//
//        when(ordersService.findAll()).thenReturn(Flux.fromIterable(ordersList));
//
//        webTestClient.get()
//                .uri("/orders/")
//                .exchange()
//                .expectStatus().isOk();
//    }
//
//    @Test
//    public void testDeleteOrder() throws Exception {
//        String orderId = "1";
//
//        when(ordersService.delete(orderId)).thenReturn(Mono.empty());
//
//        webTestClient.delete()
//                .uri("/orders/{id}", orderId)
//                .exchange()
//                .expectStatus().isOk();
//    }
//}