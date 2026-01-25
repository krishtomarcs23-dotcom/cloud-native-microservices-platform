package com.krish.cloud.customer.controller;

import com.krish.cloud.customer.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login() {
        String token = JwtUtil.generateToken("admin");
        return Map.of("token", token);
    }
}