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

import static com.sinan.productservice.constants.ProductConstants.*;

@RestController
@RequestMapping(API_PREFIX + API_VERSION_V1 + API_ORDER)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProducts(@Valid @RequestBody ProductRequest request){
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

