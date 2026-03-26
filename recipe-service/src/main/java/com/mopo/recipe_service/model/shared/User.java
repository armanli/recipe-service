package com.mopo.recipe_service.model.shared;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Username cannot be blank")
    @Column(unique = true, length = 100, nullable = false)
    private String username;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email cannot be blank")
    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Column(nullable = false)
    private String password;

    @Size(max = 15, message = "Telephone cannot exceed 15 characters")
    @Column(length = 15)
    private String telephone;

    @Builder.Default
    @Column(nullable = false)
    private boolean isActive = true;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    protected User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void toggleActive() {
        this.isActive = !this.isActive;
    }
}