package com.admin.school.entity;

import com.admin.school.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 10, unique = true)
    @NotBlank(message = "Le nom d'utilisateur   est obligatoire")
    @Size(max = 10, message = "Le nom d'utilisateur  ne doit pas dépasser 10 caractères")
    private String username;

    @Column(name = "password", nullable = false, length = 10, unique = true)
    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(max = 10, message = "Le mot de passe  ne doit pas dépasser 10 caractères")
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = " email est obligatoire")
    private String email;


    @Column(name = "role", nullable = false,length = 10, unique = true)
    @NotBlank(message = "le role est obligatoire")
    private Role role;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
