package com.infoacademy.infoacademy.services;

import com.infoacademy.infoacademy.domaine.entities.Student;

import java.util.UUID;

public interface StudentService {

    Student getStudentById(UUID idStudent);
    boolean isStudentInGroup(UUID idStudent, UUID idGroup);

}
