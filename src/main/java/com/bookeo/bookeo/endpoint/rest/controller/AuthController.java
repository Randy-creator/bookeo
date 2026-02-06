package com.bookeo.bookeo.endpoint.rest.controller;

import com.bookeo.bookeo.models.User;
import com.bookeo.bookeo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public User register(@RequestParam String username, @RequestParam String password) {
        return service.register(username, password, "USER");
    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return service.login(username, password);
    }
}

