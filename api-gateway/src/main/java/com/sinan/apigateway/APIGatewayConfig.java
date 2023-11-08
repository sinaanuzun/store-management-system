package com.sinan.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public class APIGatewayConfig {

    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("eureka-server", r -> r.path("/eureka/web").uri("http://localhost:8761/eureka"))
                .route("user-service", r -> r.path("/users/**").uri("http://localhost:8081/api/v1/"))
                .route("product-service", r -> r.path("/products/**").uri("http://localhost:8082/api/v1/"))
                .route("order-service", r -> r.path("/orders/**").uri("http://localhost:8083/api/v1/"))
                .build();
    }
}
