package com.infoacademy.infoacademy.domaine.mappers;


import com.infoacademy.infoacademy.domaine.dtos.course.CourseResponse;
import com.infoacademy.infoacademy.domaine.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {
    CourseResponse toDto(Course course);
}
