package com.infoacademy.infoacademy.domaine.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.infoacademy.infoacademy.domaine.entities.enums.SessionStatus;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "session_course",
            joinColumns = @JoinColumn(name = "id_session" , nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_course", nullable = false)
    )
    private Set<Course> courses = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "sessionsAttended")
    private Set<Student> studentsAttended = new HashSet<>();

    @OneToMany(mappedBy = "session", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Video> videos = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_group")
    private Group group;


}

