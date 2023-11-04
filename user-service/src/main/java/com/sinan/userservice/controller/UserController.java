package com.sinan.userservice.controller;

import com.sinan.userservice.dto.UserDto;
import com.sinan.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> saveUser(@RequestBody UserDto user) {
        userService.saveUser(user);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }


    @GetMapping(produces = "application/json", value = "/{username}")
    public UserDto getUser(@PathVariable String username){
        return userService.findUser(username);
    }
}
