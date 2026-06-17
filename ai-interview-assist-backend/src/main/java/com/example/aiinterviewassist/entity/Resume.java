package com.example.aiinterviewassist.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.sql.ast.tree.expression.JsonTableColumnDefinition;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
public class Resume {
    @Id
    @Column(name = "resume_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;

    @Column(name = "user_id")
    private Long userId;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

}
