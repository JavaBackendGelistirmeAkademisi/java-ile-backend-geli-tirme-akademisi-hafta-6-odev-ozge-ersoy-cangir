package com.javabackendakademisi.freelancerMatchingPlatform.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Double budget;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private User employer;

    // Getters and Setters
}
