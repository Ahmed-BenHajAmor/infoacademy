package com.infoacademy.infoacademy.domaine.entities;

import com.infoacademy.infoacademy.domaine.entities.enums.Level;
import com.infoacademy.infoacademy.domaine.entities.enums.Section;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "offer_student",
            joinColumns = @JoinColumn(name = "id_student", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_offer", nullable = false)
    )
    private Set<Offer> offers = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "video_student",
        joinColumns = @JoinColumn(name = "id_student", nullable = false),
        inverseJoinColumns =  @JoinColumn(name = "id_video", nullable = false)
    )
    private Set<Video> videosWatched = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "session_student",
            joinColumns = @JoinColumn(name = "id_student", nullable = false),
            inverseJoinColumns =  @JoinColumn(name = "id_session", nullable = false)
    )
    private Set<Session> sessionsAttended = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HomeworkSubmission> homeworkSubmissions = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "group_student",
            joinColumns = @JoinColumn(name = "id_student", nullable = false),
            inverseJoinColumns =  @JoinColumn(name = "id_group", nullable = false)
    )
    private Set<Group> groups = new HashSet<>();


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Level level;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Section section;
    private String school;

    @Column(nullable = false)
    private LocalDate dateOfBirth;
    private String profilePicture;


}
