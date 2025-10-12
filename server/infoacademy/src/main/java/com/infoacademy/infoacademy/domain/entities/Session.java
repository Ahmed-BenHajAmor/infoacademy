package com.infoacademy.infoacademy.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import com.infoacademy.infoacademy.domain.entities.enums.SessionStatus;

@Entity
@Table(name = "sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSession;

    private String title;

    @Lob
    private String description;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String link;

    @Enumerated(EnumType.STRING)
    private SessionStatus status;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
}

