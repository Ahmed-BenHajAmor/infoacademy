package com.infoacademy.infoacademy.domaine.dtos.course;

import com.infoacademy.infoacademy.domaine.entities.enums.CourseStatus;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadCourseRequest {

    @NotNull(message = "Course ID is required")
    private UUID id;

    @NotBlank(message = "Course title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotBlank(message = "Course description is required")
    @Size(min = 10, max = 1000, message = "Description must be between 10 and 1000 characters")
    private String description;

    @Positive(message = "Duration must be a positive number")
    private int duration;

    @NotNull(message = "Thumbnail image is required")
    private byte[] thumbnail;

    @NotNull(message = "Course status is required")
    private CourseStatus status;

    @NotNull(message = "You should provide a group")
    private UUID groupId;
}
