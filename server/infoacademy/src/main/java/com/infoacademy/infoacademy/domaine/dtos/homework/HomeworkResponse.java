package com.infoacademy.infoacademy.domaine.dtos.homework;

import com.infoacademy.infoacademy.domaine.dtos.course.CourseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HomeworkResponse {
    private UUID id;

    private String title;

    private String description;

    private LocalDateTime dueDate;
    private String fileUrl;
    private LocalDateTime createdAt;
    private LocalDateTime deadline;
    private byte[] thumbnail;
    private List<CourseResponse> courses;

}
