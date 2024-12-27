package com.abd.transaction.service;

import com.abd.transaction.entity.User;
import com.abd.transaction.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User getUser(long id) {
        Optional<User> byId = userRepository.findById(id);
        byId.ifPresent(user -> {
            user.setName(user.getName() + " updated name");

            userRepository.save(user);
        });

        if(true) // Because of the Runtime exception the above changes are rolled back
            throw new RuntimeException("Unwanted error");

        return byId.orElseThrow(() -> new RuntimeException("No Such User"));
    }

}
