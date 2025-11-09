package com.infoacademy.infoacademy.domaine.mappers;

import com.infoacademy.infoacademy.domaine.dtos.course.CourseResponse;
import com.infoacademy.infoacademy.domaine.dtos.homework.HomeworkResponse;
import com.infoacademy.infoacademy.domaine.dtos.homework.UploadHomeworkRequest;
import com.infoacademy.infoacademy.domaine.entities.Course;
import com.infoacademy.infoacademy.domaine.entities.Homework;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HomeworkMapper {
    @Mapping(target="courses",  source="courses", qualifiedByName = "mapCourses")
    HomeworkResponse toDto(Homework homework);

    @Named("mapCourses")
    default List<CourseResponse> mapCourses(List<Course> courses){
        return courses.stream().map(course -> {
            return CourseResponse.builder()
                    .id(course.getId())
                    .title(course.getTitle())
                    .description(course.getDescription())
                    .updatedAt(course.getUpdatedAt())
                    .createdAt(course.getCreatedAt())
                    .thumbnail(course.getThumbnail())
                    .duration(course.getDuration())
                    .build();
        }).toList();
    }

    Homework toEntity(UploadHomeworkRequest uploadHomeworkRequest);


}
