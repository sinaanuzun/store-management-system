package com.sinan.userservice.service;

import com.sinan.userservice.dto.UserDto;
import com.sinan.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() throws Exception{
        userRepository = Mockito.mock(UserRepository.class);

        userService = new UserService(userRepository);
    }

    @Test
    public void whenUserAccount(){
        UserDto userDto = new UserDto();
        userDto.setUsername("test");
        userDto.setPassword("test");
        userDto.setRole("test");
    }


}
