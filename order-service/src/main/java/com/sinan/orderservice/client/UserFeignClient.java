package com.sinan.orderservice.client;

import com.sinan.userservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserFeignClient {

    @GetMapping("/api/v1/users/{username}")
    UserDto getUserByUsername(@PathVariable String username);

    @GetMapping("/api/v1/users")
    List<UserDto> getAllUsers();
}