package com.infoacademy.infoacademy.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import com.infoacademy.infoacademy.domain.entities.enums.Difficulty;

@Entity
@Table(name = "exercises_series")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExercisesSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSerie;

    private String title;

    @Lob
    private String description;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private String fileUrl;
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
