package com.infoacademy.infoacademy.domaine.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.infoacademy.infoacademy.domaine.entities.enums.CourseStatus;

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
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private Set<Video> videos = new HashSet<>();



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "course_group",
            joinColumns = @JoinColumn(name = "id_course", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_group", nullable = false)
    )
    private Set<Group> groups = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses")
    private Set<Session> sessions = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "exercisesserie_course",
            joinColumns = @JoinColumn(name = "id_course", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_exercisesserie", nullable = false)
    )
    private Set<ExercisesSerie> exercisesSeries = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "homework_course",
            joinColumns = @JoinColumn(name = "id_course", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_homework", nullable = false)
    )
    private Set<Homework> homeworks = new HashSet<>();


}
