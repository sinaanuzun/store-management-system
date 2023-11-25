package com.sinan.orderservice.controller;

import com.sinan.orderservice.dto.request.OrderRequest;
import com.sinan.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("Order Placed Successfully");
    }

}
