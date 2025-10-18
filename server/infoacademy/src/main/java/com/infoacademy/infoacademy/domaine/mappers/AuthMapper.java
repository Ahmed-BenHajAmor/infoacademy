package com.infoacademy.infoacademy.domaine.mappers;


import com.infoacademy.infoacademy.domaine.dtos.auth.StudentRegisterRequest;
import com.infoacademy.infoacademy.domaine.entities.Student;
import com.infoacademy.infoacademy.domaine.entities.User;
import com.infoacademy.infoacademy.domaine.entities.enums.Role;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AuthMapper {

    @Mapping(target = "user", source = "studentRegisterRequest", qualifiedByName = "createUser")
    Student toStudentEntity(StudentRegisterRequest studentRegisterRequest);

    @Named("createUser")
    default User createUser(StudentRegisterRequest studentRegisterRequest){
        return User.builder().email(studentRegisterRequest.getEmail())
                .role(Role.STUDENT)
                .password(studentRegisterRequest.getPassword())
                .firstname(studentRegisterRequest.getFirstname())
                .lastname(studentRegisterRequest.getLastname())
                .build();
    }

}
