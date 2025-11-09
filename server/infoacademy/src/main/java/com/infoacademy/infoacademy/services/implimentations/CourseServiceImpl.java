package com.infoacademy.infoacademy.services.implimentations;

import com.infoacademy.infoacademy.domaine.entities.Course;
import com.infoacademy.infoacademy.domaine.entities.Professor;
import com.infoacademy.infoacademy.repositories.CourseRepository;
import com.infoacademy.infoacademy.services.CourseService;
import com.infoacademy.infoacademy.services.ProfessorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repo;
    private final ProfessorService professorService;
    @Override
    @Transactional
    public Course uploadCourse(UUID idProfessor, UUID idGroup, Course courseWithoutProfessorAttribute) throws BadRequestException {
        if(!professorService.isProfessorInGroup(idProfessor, idGroup)){
            throw  new BadRequestException("You don't have access to group with id "+idGroup.toString());
        }
        Professor professor = professorService.getProfessorById(idProfessor);
        courseWithoutProfessorAttribute.setProfessor(professor);
        return repo.save(courseWithoutProfessorAttribute);
    }

    @Override
    public Course getCourseById(UUID idCourse) {
        return repo.findById(idCourse)
                .orElseThrow(()->new EntityNotFoundException("course with id "+idCourse.toString()+" not found !!"));
    }
}
