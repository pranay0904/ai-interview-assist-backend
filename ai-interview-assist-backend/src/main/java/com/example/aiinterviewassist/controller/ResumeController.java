package com.example.aiinterviewassist.controller;

import com.example.aiinterviewassist.dto.ResumeResponseDTO;
import com.example.aiinterviewassist.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
public class ResumeController {
    private final ResumeService resumeService;
    @PostMapping("/upload")
    public ResponseEntity<ResumeResponseDTO> uploadResume (@RequestParam("file") MultipartFile file) {
            return ResponseEntity.ok(resumeService.uploadResume(file));
    }

}
