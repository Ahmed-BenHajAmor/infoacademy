package com.infoacademy.infoacademy.domaine.entities;

import com.infoacademy.infoacademy.domaine.entities.keys.HomeworkSubmissionId;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "homework_submission",
        uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "homework_id"})
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeworkSubmission {

    @EmbeddedId
    private HomeworkSubmissionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")  // Maps to the studentId in HomeworkSubmissionId
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("homeworkId")  // Maps to the homeworkId in HomeworkSubmissionId
    @JoinColumn(name = "homework_id")
    private Homework homework;

    private LocalDateTime submissionDate;

    private byte[] submittedFile;  // You can store the uploaded file path or URL

    @PrePersist
    public void prePersist() {
        submissionDate = LocalDateTime.now();
    }
}
