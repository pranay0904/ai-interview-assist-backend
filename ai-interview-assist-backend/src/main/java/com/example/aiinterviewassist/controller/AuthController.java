package com.example.aiinterviewassist.controller;

import com.example.aiinterviewassist.dto.LoginRequestDTO;
import com.example.aiinterviewassist.dto.RegisterRequestDTO;
import com.example.aiinterviewassist.dto.UserResponseDTO;
import com.example.aiinterviewassist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequestDTO registerRequestDTO){
        return ResponseEntity.ok(userService.registerUser(registerRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> loginUser (@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(userService.loginUser(loginRequestDTO));
    }
}
