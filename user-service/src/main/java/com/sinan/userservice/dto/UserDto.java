package com.sinan.userservice.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private String username;
    private String password;
    private String role;
}

