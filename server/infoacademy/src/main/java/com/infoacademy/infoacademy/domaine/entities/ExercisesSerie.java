package com.infoacademy.infoacademy.domaine.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.infoacademy.infoacademy.domaine.entities.enums.Difficulty;

@Entity
@Table(name = "exercises_series")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExercisesSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    @Lob
    private String description;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private String fileUrl;
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "exercisesSeries")
    private Set<Course> courses = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "exercisesserie_group",
            joinColumns = @JoinColumn(name = "id_exercisesserie", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_group", nullable = false)
    )
    private Set<Group> groups = new HashSet<>();
}
