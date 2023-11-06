package com.sinan.productservice.controller;

import com.sinan.productservice.dto.ProductDto;
import com.sinan.productservice.dto.request.ProductRequest;
import com.sinan.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProducts(@RequestBody @Valid ProductRequest request){
        productService.createProduct(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getResponses(){

        return ResponseEntity.ok(productService.getProducts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(name = "id") String id){

        productService.delete(id);

        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }
}

