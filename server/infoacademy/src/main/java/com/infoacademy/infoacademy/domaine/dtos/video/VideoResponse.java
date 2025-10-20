package com.infoacademy.infoacademy.domaine.dtos.video;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoResponse {
    private UUID id;
    private String title;
    private String description;
    private String url;
    private int duration;
    private LocalDateTime uploadDate;

}
