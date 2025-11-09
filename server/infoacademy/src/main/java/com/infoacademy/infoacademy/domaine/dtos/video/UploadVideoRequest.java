package com.infoacademy.infoacademy.domaine.dtos.video;

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
public class UploadVideoRequest {

    @NotNull(message = "Video ID is required")
    private UUID id;

    @NotBlank(message = "Video title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotBlank(message = "Video description is required")
    @Size(min = 10, max = 1000, message = "Description must be between 10 and 1000 characters")
    private String description;

    @NotBlank(message = "Video URL is required")
    @Pattern(
            regexp = "^(https?://).+$",
            message = "URL must be valid and start with http:// or https://"
    )
    private String url;

    @Positive(message = "Duration must be a positive number")
    private int duration;

    @NotNull(message = "Group ID is required")
    private UUID idGroup;
}
