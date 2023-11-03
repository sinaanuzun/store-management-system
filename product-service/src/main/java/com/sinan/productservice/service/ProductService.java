package com.sinan.productservice.service;

import com.sinan.productservice.dto.ProductDto;
import com.sinan.productservice.dto.converter.ProductConverter;
import com.sinan.productservice.dto.request.ProductRequest;
import com.sinan.productservice.exception.generic.IdNotFoundException;
import com.sinan.productservice.model.Product;
import com.sinan.productservice.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public void createProduct(ProductRequest request){
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId() + " " + product.getName());
    }

    public List<ProductDto> getProducts(){
        List<Product> products = productRepository.findAll();

        return productConverter.convertDtoList(products);
    }

    @Transactional
    public void delete(String id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID Not found : " + id));
        productRepository.delete(product);
        log.info("Product {} has been successfully deleted", product.getId() + " " + product.getName());
    }

}
