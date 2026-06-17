package com.example.aiinterviewassist.service.impl;

import com.example.aiinterviewassist.dto.ResumeResponseDTO;
import com.example.aiinterviewassist.entity.Resume;
import com.example.aiinterviewassist.entity.User;
import com.example.aiinterviewassist.exception.UserNotFound;
import com.example.aiinterviewassist.mapper.UserMapper;
import com.example.aiinterviewassist.repository.ResumeRepository;
import com.example.aiinterviewassist.repository.UserRepository;
import com.example.aiinterviewassist.service.ResumeService;
import com.example.aiinterviewassist.util.PdfUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.util.stream.DoubleStream.builder;

@RequiredArgsConstructor
@Service
public class ResumeServiceImpl implements ResumeService {
    private final ResumeRepository resumeRepository;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PdfUtil pdfUtil;
    @Override
    @Transactional
    public ResumeResponseDTO uploadResume(MultipartFile file){

        try{
            String email = Objects.requireNonNull(SecurityContextHolder.getContext()
                    .getAuthentication()).getName();
            User user=userRepository.findByEmail(email)
                    .orElseThrow(() -> new UserNotFound("User not found with id"));
            String uploadDir = "uploads/";
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(uploadDir+fileName);
            Files.createDirectories(path.getParent());
            Files.write(path,file.getBytes());
            String content = pdfUtil.extractText(file);
            Resume resume=Resume.builder()
                    .fileName(fileName)
                    .filePath(uploadDir+fileName)
                    .uploadedAt(LocalDateTime.now())
                    .content(content)
                    .userId(user.getUserId())
                    .build();
            resumeRepository.save(resume);
            return userMapper.resumeMapper(resume);
        }
        catch (Exception e){
            throw new RuntimeException("Failed to upload resume",e);
        }

    }
}
