package com.sinan.userservice.service;

import com.sinan.userservice.dto.UserDto;
import com.sinan.userservice.entity.User;
import com.sinan.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void saveUser(UserDto user) {
        this.userRepository.save(new User(user.getUsername(), DigestUtils.sha256Hex(user.getPassword()), user.getRole()));
    }

    public UserDto findUser(String username) {
        return this.userRepository.findById(username)
                .map(u -> new UserDto(u.getUsername(), u.getPassword(), u.getRole()))
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Username!"));
    }

}
