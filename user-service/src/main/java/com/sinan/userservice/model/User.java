package com.sinan.userservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

}
