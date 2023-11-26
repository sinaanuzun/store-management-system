package com.sinan.orderservice.dto;

public record OrderLineItemsDto(
        Long id,
        String skuCode,
        Double price,
        Integer quantity
) {
}