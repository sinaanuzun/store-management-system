package com.sinan.userservice.controller;

import com.sinan.userservice.dto.UserDto;
import com.sinan.userservice.dto.request.CreateUserRequest;
import com.sinan.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sinan.userservice.constants.UserConstants.*;

@RestController
@RequestMapping(API_PREFIX + API_VERSION_V1 + API_ORDER)
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid CreateUserRequest user) {
        log.info("save user method entry: {}", user.getUsername());
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = "application/json", value = "/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable String username) {
        UserDto userDto = userService.findUser(username);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping(produces = "application/json")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> delete(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.ok().build();

    }

}
