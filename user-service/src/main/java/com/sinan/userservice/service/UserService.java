package com.sinan.userservice.service;

import com.sinan.userservice.dto.UserDto;
import com.sinan.userservice.dto.request.CreateUserRequest;
import com.sinan.userservice.exception.generic.UserNotFoundException;
import com.sinan.userservice.model.User;
import com.sinan.userservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;


    public void saveUser(CreateUserRequest user) {
        this.userRepository.save(new User(user.getUsername(), DigestUtils.sha256Hex(user.getPassword()), user.getRole()));
    }


    public UserDto findUser(String username) {
        return this.userRepository.findById(username)
                .map(u -> new UserDto(u.getUsername(), u.getPassword(), u.getRole()))
                .orElseThrow(() -> new UserNotFoundException("Invalid Username!: " + username));
    }

    public List<UserDto> getAllUsers() {
        return ((List<User>) userRepository.findAll())
                .stream()
                .map(user -> new UserDto(user.getUsername(), user.getPassword(), user.getRole()))
                .collect(Collectors.toList());
    }

        @Transactional
        public void deleteUser(String username) {
            User user = getByUsername(username);
            log.info("User deleted successfully :{}", username);
            userRepository.deleteByUsername(user.getUsername());

        }

    private User getByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("user not found, username: " + username));
    }
}