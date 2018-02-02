package com.agileboard.service.user;

import com.agileboard.exception.EmailAlreadyExistsException;
import com.agileboard.model.User;
import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> findById(ObjectId id);
    void saveUser (User user);
    void checkEmail(String email) throws EmailAlreadyExistsException;
}
