package com.infoacademy.infoacademy.mappers;

import org.springframework.web.bind.annotation.Mapping;

import com.infoacademy.infoacademy.domaine.dto.CourseDto;
import com.infoacademy.infoacademy.domaine.entities.Course;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {

    @Mapping(target = "title", source = "title")
    @Mapping(target = "thumbnailUrl", source = "thumbnailUrl")
    CourseDto toDto(Course course);

}