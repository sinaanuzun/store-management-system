package com.sinan.productservice.dto.converter;

import com.sinan.productservice.dto.ProductDto;
import com.sinan.productservice.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {

    public ProductDto convertDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public List<ProductDto> convertDtoList(List<Product> products){
        return products.stream()
                .map(this::convertDto)
                .collect(Collectors.toList());
    }

}
