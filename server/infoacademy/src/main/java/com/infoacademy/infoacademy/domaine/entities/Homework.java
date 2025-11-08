package com.infoacademy.infoacademy.domaine.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

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

    @Column(nullable = false)
    private LocalDateTime deadline;

    private String fileUrl;
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate(){
        createdAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @Lob
    @Column(columnDefinition = "LONGBLOB")  // Use BLOB for binary data
    private byte[] thumbnail;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "homeworks")
    private List<Course> courses = new ArrayList<>();


    @OneToMany(mappedBy = "homework", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HomeworkSubmission> submissions = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "homework_group",
            joinColumns = @JoinColumn(name = "id_homework", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_group", nullable = false)
    )
    private Set<Group> groups = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return Objects.equals(id, homework.id);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
