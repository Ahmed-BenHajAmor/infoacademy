package com.infoacademy.infoacademy.domaine.dtos.homework;

import com.infoacademy.infoacademy.domaine.dtos.course.CourseResponse;
import jakarta.validation.constraints.*;
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
public class UploadHomeworkRequest {

    @NotNull(message = "Homework ID is required")
    private UUID id;

    @NotBlank(message = "Homework title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotBlank(message = "Homework description is required")
    @Size(min = 10, max = 1000, message = "Description must be between 10 and 1000 characters")
    private String description;

    @NotNull(message = "Due date is required")
    @FutureOrPresent(message = "Due date must be in the present or future")
    private LocalDateTime dueDate;

    @NotBlank(message = "File URL is required")
    @Pattern(
            regexp = "^(https?://).+$",
            message = "File URL must be valid and start with http:// or https://"
    )
    private String fileUrl;

    @NotNull(message = "Deadline is required")
    @Future(message = "Deadline must be in the future")
    private LocalDateTime deadline;

    @NotNull(message = "Thumbnail is required")
    private byte[] thumbnail;

    @NotEmpty(message = "At least one course must be associated")
    private List<@NotNull UUID> idCourses;

    @NotNull(message = "Group ID is required")
    private UUID idGroup;
}
