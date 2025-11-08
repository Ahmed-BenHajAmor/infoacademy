package com.infoacademy.infoacademy.domaine.dtos.course;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponse {
    private UUID id;
    private String title;
    private String description;
    private int duration;
    private byte[] thumbnail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
