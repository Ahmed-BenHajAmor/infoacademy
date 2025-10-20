package com.infoacademy.infoacademy.domaine.mappers;

import com.infoacademy.infoacademy.domaine.dtos.homework.HomeworkResponse;
import com.infoacademy.infoacademy.domaine.entities.Homework;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HomeworkMapper {
    HomeworkResponse toDto(Homework homework);
}
