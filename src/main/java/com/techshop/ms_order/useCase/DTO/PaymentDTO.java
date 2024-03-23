package com.techshop.ms_order.useCase.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
    @JsonProperty()
    public String status;
    @JsonProperty()
    public String method;
    @JsonProperty("user_id")
    public Long userId;
    @JsonProperty()
    public Double value;

}
