package com.sinan.orderservice.controller;

import com.sinan.orderservice.dto.request.OrderRequest;
import com.sinan.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sinan.orderservice.constants.OrderConstants.*;

@RestController
@RequestMapping(API_PREFIX + API_VERSION_V1 + API_ORDER)
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest) {
         orderService.placeOrder(orderRequest);

        log.info("Placing Order");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Order Placed Successfully");

    }

}
