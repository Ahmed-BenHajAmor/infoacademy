package com.infoacademy.infoacademy.domaine.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "student_groups")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private int number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            nullable = false,
            name = "id_offer"
    )
    private Offer offer;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    private Set<Student> students = new HashSet<>();

    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private Set<Video> videos = new HashSet<>();

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Session> sessions = new HashSet<>();

    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private Set<Course> courses = new HashSet<>();

    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private Set<Homework> homeworks = new HashSet<>();

    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private Set<ExercisesSerie> exercisesSeries = new HashSet<>();

    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private Set<Professor> professors = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
