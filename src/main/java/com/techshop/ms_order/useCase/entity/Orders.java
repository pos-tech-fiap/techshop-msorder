package com.techshop.ms_order.useCase.entity;

import com.techshop.ms_order.useCase.DTO.OrdersDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Orders {
    @Id
    private String id;
    private String productId;
    private int quantity;
    private String customerName;
    private String customerEmail;
    private String shippingAddress;
    private String paymentMethod;
    private Double value;
    private String status;

    public Orders() {
    }

    public Orders(String productId, int quantity, String customerName, String customerEmail, String shippingAddress, String paymentMethod, Double value, String status) {
        this.productId = productId;
        this.quantity = quantity;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.value = value;
        this.status = status;
    }

    public Orders(OrdersDTO ordersDTO) {
        this.productId = ordersDTO.productId();
        this.quantity = ordersDTO.quantity();
        this.customerName = ordersDTO.customerName();
        this.customerEmail = ordersDTO.customerEmail();
        this.shippingAddress = ordersDTO.shippingAddress();
        this.paymentMethod = ordersDTO.paymentMethod();
        this.value = ordersDTO.valueMethod();
        this.status = ordersDTO.status();
    }
}