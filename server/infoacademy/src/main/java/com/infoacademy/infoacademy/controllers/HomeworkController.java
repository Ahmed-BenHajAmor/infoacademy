package com.infoacademy.infoacademy.controllers;

import com.infoacademy.infoacademy.domaine.dtos.homework.HomeworkResponse;
import com.infoacademy.infoacademy.domaine.dtos.homework.UploadHomeworkRequest;
import com.infoacademy.infoacademy.domaine.entities.Homework;
import com.infoacademy.infoacademy.domaine.mappers.HomeworkMapper;
import com.infoacademy.infoacademy.services.HomeworkService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;



@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/homework")
public class HomeworkController {

    private final HomeworkService service;
    private final HomeworkMapper mapper;

    @PostMapping("/submit")
    public ResponseEntity submitHomework(@RequestParam UUID idHomework,
                                         @RequestAttribute("id_user") UUID  LoggedInStudent,
                                         @RequestParam("pdfFile") MultipartFile pdfFile) throws IOException {

        if(!"application/pdf".equals(pdfFile.getContentType())) {
            throw new BadRequestException("File type needs to be pdf !!");
        }
        service.submitHomework(idHomework, LoggedInStudent, pdfFile);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PostMapping("/uplooad")
    public ResponseEntity<HomeworkResponse> uploadHomework(
            @RequestAttribute("id_user") UUID loggedInProfessor,
            @RequestBody UploadHomeworkRequest request
    ) throws BadRequestException {
        Homework newHomeworkWithoutProfessorAndCoursesAttributes = mapper.toEntity(request);
        Homework homework = service.uploadHomework(loggedInProfessor, request.getIdGroup(), request.getIdCourses(), newHomeworkWithoutProfessorAndCoursesAttributes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toDto(homework));
    }





}
