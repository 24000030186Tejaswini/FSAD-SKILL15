package com.klu.jwt.controller;

import com.klu.jwt.model.User;
import com.klu.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    JwtUtil jwtUtil = new JwtUtil();

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        // ✅ SAFE CHECK FIRST
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            return "Invalid input";
        }

        // ✅ USE CONSTANT ON LEFT SIDE (VERY IMPORTANT)
        if ("admin".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            return jwtUtil.generateToken("admin", "ADMIN");
        }

        if ("emp".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            return jwtUtil.generateToken("emp", "EMPLOYEE");
        }

        return "Invalid credentials";
    
    }
}