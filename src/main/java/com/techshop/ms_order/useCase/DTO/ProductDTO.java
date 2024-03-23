package com.techshop.ms_order.useCase.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    @JsonProperty("product_id")
    public String productId;
    @JsonProperty()
    public String name;
    @JsonProperty()
    public String description;
    @JsonProperty()
    public int quantity;
    @JsonProperty()
    public double price;
}
