package com.example.aiinterviewassist.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class ResumeResponseDTO {
    private Long resumeId;
    private String fileName;
    private LocalDateTime uploadedAt;
}
