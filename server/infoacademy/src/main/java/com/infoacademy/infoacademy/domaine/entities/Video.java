package com.infoacademy.infoacademy.domaine.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "videos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    @Lob
    private String description;

    private String url;
    private int duration;
    private LocalDateTime uploadDate;

    @PrePersist
    public void onCreate(){
        uploadDate = LocalDateTime.now();
    }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_session")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "videosWatched")
    private Set<Student> studentsWatched = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "group_video",
            joinColumns = @JoinColumn(name = "id_video", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_group", nullable = false)
    )
    private Set<Group> groups = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(id, video.id);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
