package com.infoacademy.infoacademy.domaine.dtos.homework;

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
public class HomeworkResponse {
    private UUID id;

    private String title;

    private String description;

    private LocalDateTime dueDate;
    private String fileUrl;
    private LocalDateTime createdAt;


}
