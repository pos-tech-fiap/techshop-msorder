package com.techshop.ms_order.useCase.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
public record OrdersDTO(
        @JsonProperty("product_id")
        @NotBlank(message = "ProductID field is required!")
        String productId,
        @JsonProperty()
        @NotBlank(message = "Quantity field is required!")
        int quantity,
        @JsonProperty("customer_name")
        @NotBlank(message = "Customer name field is required!")
        String customerName,
        @JsonProperty("customer_email")
        @NotBlank(message = "Customer email field is required!")
        String customerEmail,
        @JsonProperty("shipping_address")
        @NotBlank(message = "Shipping address field is required!")
        String shippingAddress,
        @JsonProperty("payment_method")
        @NotBlank(message = "Payment method field is required!")
        String paymentMethod,
        @NotBlank(message = "Value field is required!")
        Double value,
        @JsonProperty()
        String status

) {
    public String productId() { return productId; };
    public int quantity() { return quantity; };
    public String customerName() { return  customerName; };
    public String customerEmail() { return  customerEmail; };
    public String shippingAddress() { return shippingAddress;};
    public String paymentMethod() { return  paymentMethod; };
    public Double valueMethod() { return  value; };
    public String status() { return  status; };

}
