package com.example.aiinterviewassist.service;

import com.example.aiinterviewassist.dto.AtsResponseDTO;
import com.example.aiinterviewassist.dto.ResumeAnalysisResponseDTO;


public interface ResumeAnalysisService {
    ResumeAnalysisResponseDTO analyzeResume(Long resumeId);

    AtsResponseDTO calculateAtsScore(Long resumeId, String jobDescription);
}
