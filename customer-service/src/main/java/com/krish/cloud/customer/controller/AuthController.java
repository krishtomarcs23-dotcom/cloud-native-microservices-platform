package com.krish.cloud.customer.controller;

import com.krish.cloud.customer.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username) {
        return jwtUtil.generateToken(username);
    }
}