package com.bookeo.bookeo.service;

import com.bookeo.bookeo.models.User;
import com.bookeo.bookeo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();

    public User register(String username, String password, String role) {
        User user = User.builder()
                .username(username)
                .passwordHash(encoder.encode(password))
                .role(role)
                .build();

        return userRepo.save(user);
    }

    public User login(String username, String password) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(password, user.getPasswordHash())) {
            throw new RuntimeException("Invalid password");
        }
        return user;
    }
}
