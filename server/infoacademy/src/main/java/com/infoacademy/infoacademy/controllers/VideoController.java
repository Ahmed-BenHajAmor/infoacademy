package com.infoacademy.infoacademy.controllers;


import com.infoacademy.infoacademy.domaine.dtos.video.UploadVideoRequest;
import com.infoacademy.infoacademy.domaine.dtos.video.VideoResponse;
import com.infoacademy.infoacademy.domaine.entities.Video;
import com.infoacademy.infoacademy.domaine.mappers.VideoMapper;
import com.infoacademy.infoacademy.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/video")
public class VideoController {

    private final VideoService service;
    private final VideoMapper mapper;

    @PostMapping("/upload")
    public ResponseEntity<VideoResponse> uploadVideo(
            @RequestAttribute("id_user")UUID loggedInProfessor,
            @RequestBody UploadVideoRequest request
    ){
        Video newVideoWithoutProfessorAttribute = mapper.toEntity(request);
        Video video = service.uploadVideo(loggedInProfessor, request.getIdGroup(), newVideoWithoutProfessorAttribute);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toDto(video));
    }



}
