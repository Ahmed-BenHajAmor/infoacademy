package com.infoacademy.infoacademy.services;

import com.infoacademy.infoacademy.domaine.entities.Professor;
import com.infoacademy.infoacademy.domaine.entities.Student;

import java.util.UUID;

public interface ProfessorService {
    Professor getProfessorById(UUID idProfessor);
    boolean isProfessorInGroup(UUID idSProfessor, UUID idGroup);
}
