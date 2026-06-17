package com.example.aiinterviewassist.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResumeAnalysisResponseDTO {
    private List<String> skills;
}
