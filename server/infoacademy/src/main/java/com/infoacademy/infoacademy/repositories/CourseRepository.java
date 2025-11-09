package com.infoacademy.infoacademy.repositories;

import com.infoacademy.infoacademy.domaine.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {


}
