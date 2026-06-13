package com.example.aiinterviewassist.service.impl;

import com.example.aiinterviewassist.dto.RegisterRequestDTO;
import com.example.aiinterviewassist.entity.User;
import com.example.aiinterviewassist.mapper.UserMapper;
import com.example.aiinterviewassist.repository.UserRepository;
import com.example.aiinterviewassist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public String registerUser(RegisterRequestDTO registerRequestDTO) {
        if (userRepository.findByEmail(registerRequestDTO.getEmail()).isPresent()){
            return "User already Exists";
        }
        User user =userMapper.registerMapper(registerRequestDTO);
        userRepository.save(user);
        return "User Registered Successfully";
    }
}
