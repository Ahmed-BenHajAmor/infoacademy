package com.infoacademy.infoacademy.services;

import com.infoacademy.infoacademy.domaine.entities.Homework;
import org.apache.coyote.BadRequestException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface HomeworkService {
    void submitHomework(UUID idHomework, UUID idStudent, MultipartFile pdfFile) throws IOException;
    Homework uploadHomework(UUID idProfessor, UUID idGroup, List<UUID> idCourses, Homework homeworkWithoutProfessorAndCoursesAttributes) throws BadRequestException;

}
