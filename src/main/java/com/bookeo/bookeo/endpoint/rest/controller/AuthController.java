package com.bookeo.bookeo.endpoint.rest.controller;

import com.bookeo.bookeo.models.Role;
import com.bookeo.bookeo.models.User;
import com.bookeo.bookeo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public User register(@RequestParam String username, @RequestParam String password) {
        return service.register(username, password, Role.USER);
    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return service.login(username, password);
    }
}

