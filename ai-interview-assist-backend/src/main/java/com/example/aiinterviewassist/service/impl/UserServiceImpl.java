package com.example.aiinterviewassist.service.impl;

import com.example.aiinterviewassist.dto.LoginRequestDTO;
import com.example.aiinterviewassist.dto.RegisterRequestDTO;
import com.example.aiinterviewassist.dto.UserResponseDTO;
import com.example.aiinterviewassist.entity.User;
import com.example.aiinterviewassist.exception.EmailAlreadyExists;
import com.example.aiinterviewassist.exception.UserNotFound;
import com.example.aiinterviewassist.mapper.UserMapper;
import com.example.aiinterviewassist.repository.UserRepository;
import com.example.aiinterviewassist.security.JwtService;
import com.example.aiinterviewassist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public String registerUser(RegisterRequestDTO registerRequestDTO) {
        if (userRepository.findByEmail(registerRequestDTO.getEmail()).isPresent()){
            throw new EmailAlreadyExists("Email already exists");
        }

        User user =userMapper.registerMapper(registerRequestDTO);
        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        userRepository.save(user);
        return "User Registered Successfully";
    }

    @Override
    public UserResponseDTO loginUser(LoginRequestDTO loginRequestDTO){
        User user =userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new UserNotFound("User not found"));
        String token =
                jwtService.generateToken(
                        user.getEmail()
                );

        return UserResponseDTO.builder()
                .token(token)
                .name(user.getName())
                .email(user.getEmail())
                .userId(String.valueOf(user.getUserId()))
                .role(user.getRole())
                .build();
    }
}
