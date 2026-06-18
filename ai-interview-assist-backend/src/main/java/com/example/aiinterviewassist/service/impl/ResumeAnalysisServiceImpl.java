package com.example.aiinterviewassist.service.impl;

import com.example.aiinterviewassist.dto.AtsRequestDTO;
import com.example.aiinterviewassist.dto.AtsResponseDTO;
import com.example.aiinterviewassist.dto.ResumeAnalysisRequestDTO;
import com.example.aiinterviewassist.dto.ResumeAnalysisResponseDTO;

import com.example.aiinterviewassist.entity.Resume;
import com.example.aiinterviewassist.exception.ResumeNotFound;
import com.example.aiinterviewassist.mapper.UserMapper;
import com.example.aiinterviewassist.repository.ResumeRepository;
import com.example.aiinterviewassist.service.ResumeAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ResumeAnalysisServiceImpl implements ResumeAnalysisService {
    private final ResumeRepository resumeRepository;
    private final UserMapper userMapper;
    private final RestTemplate restTemplate;
    @Override
    public ResumeAnalysisResponseDTO analyzeResume(Long resumeId){
        Resume resume = resumeRepository.findByResumeId(resumeId)
                .orElseThrow(()-> new ResumeNotFound("Resume not found"));
        ResumeAnalysisRequestDTO requestContent = ResumeAnalysisRequestDTO.builder()
                .resumeContent(resume.getContent())
                .build();
        return restTemplate.postForObject("http://localhost:8000/ats_score",
                requestContent, ResumeAnalysisResponseDTO.class);
    }

    @Override
    public AtsResponseDTO calculateAtsScore(Long resumeId, String jobDescription){
        Resume resume = resumeRepository.findByResumeId(resumeId)
                .orElseThrow(() -> new ResumeNotFound("Resume not found"));
        AtsRequestDTO atsRequestDTO = AtsRequestDTO.builder()
                .resumeContent(resume.getContent())
                .jobDescription(jobDescription)
                .build();
        return restTemplate.postForObject("http://localhost:8000/ats_score",atsRequestDTO,AtsResponseDTO.class);
    }

}
