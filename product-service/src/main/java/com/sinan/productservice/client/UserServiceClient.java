package com.sinan.productservice.client;

import com.sinan.userservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserServiceClient {

    @GetMapping("/api/v1/users")
    ResponseEntity<List<UserDto>> getAllUsers();
}