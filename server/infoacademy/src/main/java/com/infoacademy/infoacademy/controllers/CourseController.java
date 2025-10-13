package com.infoacademy.infoacademy.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.infoacademy.infoacademy.domaine.dto.CourseDto;
import com.infoacademy.infoacademy.domaine.entities.Course;
import com.infoacademy.infoacademy.services.CourseService;

import lombok.RequiredArgsConstructor;

@RequestMapping(path = "/api/v1/courses")
@RequiredArgsConstructor
@Controller
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;
    
    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        List<CourseDto> courseDtos = courses.stream().map(courseMapper::toDto).toList();
        return ResponseEntity.ok(courseDtos);
    }
}
