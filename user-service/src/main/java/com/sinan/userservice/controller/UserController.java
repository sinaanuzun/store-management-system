package com.sinan.userservice.controller;

import com.sinan.userservice.dto.UserDto;
import com.sinan.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
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

    @GetMapping(produces = "application/json")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.ok().build();
    }
}
