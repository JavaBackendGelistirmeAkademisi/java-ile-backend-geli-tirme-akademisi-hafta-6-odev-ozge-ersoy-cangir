package com.javabackendakademisi.freelancerMatchingPlatform.entity;

import jakarta.persistence.*;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;  // Teklif tutarı
    private String description;  // Teklif açıklaması

    @ManyToOne
    @JoinColumn(name = "freelancer_id", nullable = false)
    private User freelancer;  // Teklifi veren serbest çalışan

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;  // Teklif verilen proje

    // Getter ve Setter metodları

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(User freelancer) {
        this.freelancer = freelancer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}