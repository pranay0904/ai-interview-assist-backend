package com.example.aiinterviewassist.repository;

import com.example.aiinterviewassist.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository <Resume, Long>{
}
