package com.sinan.productservice.service;

import com.sinan.productservice.dto.ProductRequest;
import com.sinan.productservice.dto.ProductResponse;
import com.sinan.productservice.model.Product;
import com.sinan.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest request){
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId() + " " + product.getName());
    }

    public List<ProductResponse> getProducts(){
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(this::productResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse productResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
