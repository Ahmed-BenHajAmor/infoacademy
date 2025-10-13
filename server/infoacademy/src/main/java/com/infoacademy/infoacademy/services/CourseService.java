package com.infoacademy.infoacademy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infoacademy.infoacademy.domaine.entities.Course;
import com.infoacademy.infoacademy.repositories.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository = null;

    public List<Course> getAllCourses(Course course) {
        return courseRepository.findAllCourses();
    }
}
