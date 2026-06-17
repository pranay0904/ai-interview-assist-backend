package com.example.aiinterviewassist.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResumeAnalysisRequestDTO {
    private String resumeContent;
}
