package com.agileboard.service.user;

import com.agileboard.exception.EmailAlreadyExistsException;
import com.agileboard.model.User;
import com.agileboard.persistence.UserRepository;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("no user with username: " + username));
    }

    @Override
    public Optional<User> findById(@NonNull ObjectId id) {
        return userRepository.findById(id);
    }

    @Override
    public void saveUser(@NonNull User user) {
        userRepository.save(user);
    }

    @Override
    public void checkEmail(String email) throws EmailAlreadyExistsException {
        if (userRepository.findByUsername(email).isPresent()){
            throw new EmailAlreadyExistsException("email already exist: " + email);
        }
    }
}
