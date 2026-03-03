package com.seuprojeto.mopo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "revenues")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Title is required")
    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 300)
    private String description;

    @Lob
    private String image;

    @ElementCollection
    @CollectionTable(name = "revenue_ingredients", joinColumns = @JoinColumn(name = "revenue_id"))
    @Column(name = "ingredient")
    @NotEmpty(message = "Ingredients list cannot be empty")
    private List<String> ingredients = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "revenue_instructions", joinColumns = @JoinColumn(name = "revenue_id"))
    @Column(name = "instruction")
    @NotEmpty(message = "Instructions list cannot be empty")
    private List<String> instructions = new ArrayList<>();

    @PositiveOrZero(message = "Preparation time must be positive")
    private int preparationTime;

    @PositiveOrZero
    private int efficiency;

    @Min(0)
    @Max(5)
    private int rating;

    @Min(1)
    @Max(3)
    private int difficulty;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}