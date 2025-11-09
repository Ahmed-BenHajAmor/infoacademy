package com.infoacademy.infoacademy.services.implimentations;

import com.infoacademy.infoacademy.domaine.entities.Group;
import com.infoacademy.infoacademy.domaine.entities.Professor;
import com.infoacademy.infoacademy.domaine.entities.Student;
import com.infoacademy.infoacademy.repositories.ProfessorRepository;
import com.infoacademy.infoacademy.repositories.StudentRepository;
import com.infoacademy.infoacademy.services.GroupService;
import com.infoacademy.infoacademy.services.ProfessorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository repo;
    private final GroupService groupService;

    @Override
    public Professor getProfessorById(UUID idProfessor) {
        return repo.findById(idProfessor).orElseThrow(()-> new EntityNotFoundException("student do not exist !!"));
    }

    @Override
    @Transactional
    public boolean isProfessorInGroup(UUID idProfessor, UUID idGroup) {
        Professor professor = this.getProfessorById(idProfessor);
        Group group = groupService.getGroupById(idGroup);
        return !professor.getGroups().contains(group);
    }
}
