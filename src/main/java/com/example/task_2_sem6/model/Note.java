package com.example.task_2_sem6.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String title;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();



}

