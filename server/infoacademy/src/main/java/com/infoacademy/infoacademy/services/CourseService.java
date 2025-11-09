package com.infoacademy.infoacademy.services;

import com.infoacademy.infoacademy.domaine.entities.Course;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    Course uploadCourse(UUID idProfessor, UUID idGroup, Course courseWithoutProfessorAttribute) throws BadRequestException;
    Course getCourseById(UUID idCourse);
}
