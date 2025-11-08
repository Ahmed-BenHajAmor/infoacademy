package com.infoacademy.infoacademy.domaine.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
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
    @JoinColumn(name = "id")
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "group_professor",
            joinColumns = @JoinColumn(name = "id_professor", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_group", nullable = false)
    )
    private Set<Group> groups = new HashSet<>();

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Offer> offers;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
