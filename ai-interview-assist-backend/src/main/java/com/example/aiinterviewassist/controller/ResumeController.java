package com.example.aiinterviewassist.controller;

import com.example.aiinterviewassist.dto.AtsResponseDTO;
import com.example.aiinterviewassist.dto.ResumeAnalysisResponseDTO;
import com.example.aiinterviewassist.dto.ResumeResponseDTO;
import com.example.aiinterviewassist.service.ResumeAnalysisService;
import com.example.aiinterviewassist.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
public class ResumeController {
    private final ResumeService resumeService;
    private final ResumeAnalysisService resumeAnalysisService;
    @PostMapping("/upload")
    public ResponseEntity<ResumeResponseDTO> uploadResume (@RequestParam("file") MultipartFile file) {
            return ResponseEntity.ok(resumeService.uploadResume(file));
    }

    @GetMapping("analyze/{resumeId}")
    public ResponseEntity<ResumeAnalysisResponseDTO> analyzeResume(@PathVariable("resumeId") Long ResumeId){
        return ResponseEntity.ok(resumeAnalysisService.analyzeResume(ResumeId));
    }

    @GetMapping("/ats/{resumeId}")
    public ResponseEntity<AtsResponseDTO> getAtsScore(@PathVariable("resumeId") Long resumeId, @RequestParam("jobDescription") String jobDescription){
        return ResponseEntity.ok(resumeAnalysisService.calculateAtsScore(resumeId, jobDescription));
    }

}
