package com.example.aiinterviewassist.repository;

import com.example.aiinterviewassist.entity.Resume;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository <Resume, Long>{
    Optional<Resume> findByResumeId(Long resumeId);
}
