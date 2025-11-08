package com.infoacademy.infoacademy.domaine.mappers;


import com.infoacademy.infoacademy.domaine.dtos.auth.ProfessorRegisterRequest;
import com.infoacademy.infoacademy.domaine.entities.Professor;
import com.infoacademy.infoacademy.domaine.entities.Student;
import com.infoacademy.infoacademy.domaine.entities.User;
import com.infoacademy.infoacademy.domaine.dtos.auth.StudentRegisterRequest;
import com.infoacademy.infoacademy.domaine.entities.enums.Role;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AuthMapper {

    @Mapping(target = "user", source = "studentRegisterRequest", qualifiedByName = "createStudent")
    Student toStudentEntity(StudentRegisterRequest studentRegisterRequest);

    @Mapping(target = "user", source = "professorRegisterRequest", qualifiedByName = "createProfessor")
    Professor toProfessorEntity(ProfessorRegisterRequest professorRegisterRequest);

    @Named("createStudent")
    default User createStudent(StudentRegisterRequest studentRegisterRequest){
        return User.builder().email(studentRegisterRequest.getEmail())
                .role(Role.STUDENT)
                .password(studentRegisterRequest.getPassword())
                .firstname(studentRegisterRequest.getFirstname())
                .lastname(studentRegisterRequest.getLastname())
                .build();
    }

    @Named("createProfessor")
    default User createProfessor(ProfessorRegisterRequest professorRegisterRequest){
        return User.builder().email(professorRegisterRequest.getEmail())
                .role(Role.PROFESSOR)
                .password(professorRegisterRequest.getPassword())
                .firstname(professorRegisterRequest.getFirstname())
                .lastname(professorRegisterRequest.getLastname())
                .build();
    }

}
