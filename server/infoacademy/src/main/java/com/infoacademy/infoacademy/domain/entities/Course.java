package com.infoacademy.infoacademy.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import com.infoacademy.infoacademy.domain.entities.enums.CourseStatus;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;

    @Column(nullable = false)
    private String title;

    @Lob
    private String description;

    private String category;
    private String level;
    private String language;
    private int duration;
    private String thumbnailUrl;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
