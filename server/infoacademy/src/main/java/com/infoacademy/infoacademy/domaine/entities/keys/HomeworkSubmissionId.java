package com.infoacademy.infoacademy.domaine.entities.keys;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeworkSubmissionId implements Serializable {
    private UUID studentId;
    private UUID homeworkId;
}
