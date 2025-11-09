package com.infoacademy.infoacademy.services.implimentations;

import com.infoacademy.infoacademy.domaine.entities.Group;
import com.infoacademy.infoacademy.domaine.entities.Student;
import com.infoacademy.infoacademy.domaine.entities.User;
import com.infoacademy.infoacademy.domaine.entities.enums.Role;
import com.infoacademy.infoacademy.repositories.StudentRepository;
import com.infoacademy.infoacademy.services.GroupService;
import com.infoacademy.infoacademy.services.StudentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repo;
    private final GroupService groupService;

    @Override
    public Student getStudentById(UUID idStudent) {
        return repo.findById(idStudent).orElseThrow(()-> new EntityNotFoundException("student do not exist !!"));
    }

    @Override
    @Transactional
    public boolean isStudentInGroup(UUID idStudent, UUID idGroup) {
        Student student = this.getStudentById(idStudent);
        Group group = groupService.getGroupById(idGroup);
        return !student.getGroups().contains(group);
    }
}
