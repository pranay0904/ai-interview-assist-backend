package com.example.aiinterviewassist.service;

import com.example.aiinterviewassist.dto.LoginRequestDTO;
import com.example.aiinterviewassist.dto.RegisterRequestDTO;
import com.example.aiinterviewassist.dto.UserResponseDTO;

public interface UserService {
    String registerUser(RegisterRequestDTO registerRequestDTO);

    UserResponseDTO loginUser(LoginRequestDTO loginRequestDTO);
}
