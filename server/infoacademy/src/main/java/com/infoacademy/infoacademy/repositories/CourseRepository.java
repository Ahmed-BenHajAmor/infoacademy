package com.infoacademy.infoacademy.repositories;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.infoacademy.infoacademy.domaine.entities.Course;

@Repository
public interface CourseRepository{
    List<Course> findAllCourses();
    
}
