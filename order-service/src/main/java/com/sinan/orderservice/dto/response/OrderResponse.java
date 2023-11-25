package com.sinan.orderservice.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private String skuCode;
    private Double price;
    private Integer quantity;
}
