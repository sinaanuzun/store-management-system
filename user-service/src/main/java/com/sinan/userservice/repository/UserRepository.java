package com.sinan.userservice.repository;

import com.sinan.userservice.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    void deleteByUsername(String username);
    Optional<User> findUserByUsername(String username);

}
