//package com.techshop.ms_order.service;
//
//import com.techshop.ms_order.repository.OrdersRepository;
//import com.techshop.ms_order.useCase.DTO.OrdersDTO;
//import com.techshop.ms_order.useCase.entity.Orders;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
//import org.springframework.boot.test.context.SpringBootTest;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@AutoConfigureWebTestClient
//public class OrdersServiceTest {
//
//    @Mock
//    private OrdersRepository ordersRepository;
//
//    @InjectMocks
//    private OrdersService ordersService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
////    @Test
////    public void testSaveOrder() {
////        OrdersDTO ordersDTO = new OrdersDTO("1", 5, "Flor da Silva", "flor@example.com", "Rua ABC, 123", "credit_card",  2.00,"PENDING");
////        Orders savedOrder = new Orders(ordersDTO);
////
////        when(ordersRepository.save(any(Orders.class))).thenReturn(Mono.just(savedOrder));
////
////        StepVerifier.create(ordersService.save(ordersDTO))
////                .expectNext(savedOrder)
////                .verifyComplete();
////    }
//
//    @Test
//    public void testGetOrderById() {
//        OrdersDTO ordersDTO = new OrdersDTO("1", 5, "Flor da Silva", "flor@example.com", "Rua ABC, 123", "credit_card",  2.00,"PENDING");
//        Orders savedOrder = new Orders(ordersDTO);
//        String orderId = "65ecb34355b73c3abc3e3836";
//
//        when(ordersRepository.findById(orderId)).thenReturn(Mono.just(Optional.of(savedOrder)));
//
//        StepVerifier.create(ordersService.getOrderById(orderId))
//                .expectNext(savedOrder)
//                .verifyComplete();
//    }
//
//    @Test
//    public void testFindAllOrders() {
//        OrdersDTO ordersDTO = new OrdersDTO("1", 5, "Flor da Silva", "flor@example.com", "Rua ABC, 123", "credit_card",  2.00,"PENDING");
//        List<Orders> ordersList = Arrays.asList(
//                new Orders(ordersDTO),
//                new Orders(ordersDTO),
//                new Orders(ordersDTO)
//        );
//
//        when(ordersRepository.findAll()).thenReturn(Flux.fromIterable(ordersList));
//
//        StepVerifier.create(ordersService.findAll())
//                .expectNextSequence(ordersList)
//                .verifyComplete();
//    }
//
//    @Test
//    public void testDeleteOrder() {
//        String orderId = "65ecb34355b73c3abc3e3836";
//
//        when(ordersRepository.delete(orderId)).thenReturn(Mono.empty());
//
//        StepVerifier.create(ordersService.delete(orderId))
//                .verifyComplete();
//    }
//
////    @Test
////    public void testSaveOrderError() {
////        OrdersDTO ordersDTO = new OrdersDTO("1", 5, "Flor da Silva", "flor@example.com", "Rua ABC, 123", "credit_card",  2.00,"PENDING");
////
////        when(ordersRepository.save(any(Orders.class))).thenReturn(Mono.error(new RuntimeException("Failed to save order")));
////
////        StepVerifier.create(ordersService.save(ordersDTO))
////                .verifyErrorMessage("Failed to save order");
////    }
//
//    @Test
//    public void testFindAllOrdersError() {
//        when(ordersRepository.findAll()).thenReturn(Flux.error(new RuntimeException("Failed to find orders")));
//
//        StepVerifier.create(ordersService.findAll())
//                .verifyErrorMessage("Failed to find orders");
//    }
//
//    @Test
//    public void testDeleteOrderError() {
//        String orderId = "65ecb34355b73c3abc3e3836";
//
//        when(ordersRepository.delete(orderId)).thenReturn(Mono.error(new RuntimeException("Failed to delete order")));
//
//        StepVerifier.create(ordersService.delete(orderId))
//                .verifyErrorMessage("Failed to delete order");
//    }
//}