package com.infoacademy.infoacademy.controllers;


import com.infoacademy.infoacademy.domaine.dtos.course.CourseResponse;
import com.infoacademy.infoacademy.domaine.dtos.course.UploadCourseRequest;
import com.infoacademy.infoacademy.domaine.entities.Course;
import com.infoacademy.infoacademy.domaine.mappers.CourseMapper;
import com.infoacademy.infoacademy.services.CourseService;
import com.infoacademy.infoacademy.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;
    private final CourseMapper mapper;

    @PostMapping("upload")
    public ResponseEntity<CourseResponse> uploadCourse(
            @RequestAttribute("id_user") UUID loggedInProfessor,
            @Valid @RequestBody UploadCourseRequest request
    ) throws BadRequestException {
        Course newCourseWithoutProfessorAttribute = mapper.toEntity(request);
        Course uploadedCourse = service.uploadCourse(loggedInProfessor, request.getGroupId(), newCourseWithoutProfessorAttribute);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toDto(uploadedCourse));
    }

}
