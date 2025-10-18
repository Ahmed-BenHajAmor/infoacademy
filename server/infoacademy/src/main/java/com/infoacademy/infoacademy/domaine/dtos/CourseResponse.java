package com.infoacademy.infoacademy.domaine.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseResponse {
    private String title;
    private String thumbnailUrl;
}
