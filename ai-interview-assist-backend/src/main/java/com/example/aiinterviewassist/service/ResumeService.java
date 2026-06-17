package com.example.aiinterviewassist.service;

import com.example.aiinterviewassist.dto.ResumeResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface ResumeService {
    ResumeResponseDTO uploadResume(MultipartFile file);
}
