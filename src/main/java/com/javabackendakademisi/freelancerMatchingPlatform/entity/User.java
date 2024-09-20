package com.javabackendakademisi.freelancerMatchingPlatform.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Double balance;

    public enum Role {
        EMPLOYER, FREELANCER
    }
}
