package com.infoacademy.infoacademy.domaine.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "professors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professor {

    @Id
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_user")
    private User user;

    private String speciality;
    private String bio;
    private String institution;
    private String profilePicture;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "professor")
    private Set<Video> videos = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "professor")
    private Set<Session> sessions = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "professor")
    private Set<ExercisesSerie> exercisesSeries = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "professor")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "professor")
    private Set<Homework> homeworks = new HashSet<>();




}
