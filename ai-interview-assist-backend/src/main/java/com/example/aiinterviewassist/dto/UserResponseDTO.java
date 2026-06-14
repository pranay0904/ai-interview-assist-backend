package com.example.aiinterviewassist.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class UserResponseDTO {
    private String name;
    private String email;
    private String userId;
    private String role;
    private String token;
}
