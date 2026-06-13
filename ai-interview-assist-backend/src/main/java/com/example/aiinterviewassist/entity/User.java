package com.example.aiinterviewassist.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long userId;

    @Column
    private String name;

    @Column (unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String role;
}
