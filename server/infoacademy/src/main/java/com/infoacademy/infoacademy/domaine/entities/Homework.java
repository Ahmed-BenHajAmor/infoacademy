package com.infoacademy.infoacademy.domaine.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "homeworks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    @Lob
    private String description;

    private LocalDateTime dueDate;
    private String fileUrl;
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate(){
        createdAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "homeworks")
    private Set<Course> courses = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "homeworksSubmitted")
    private Set<Student> studentsSubmitted;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "homework_group",
            joinColumns = @JoinColumn(name = "id_homework", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_group", nullable = false)
    )
    private Set<Group> groups = new HashSet<>();
}
