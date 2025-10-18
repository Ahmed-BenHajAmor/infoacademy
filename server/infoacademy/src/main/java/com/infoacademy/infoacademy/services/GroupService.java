package com.infoacademy.infoacademy.services;

import java.util.Set;
import java.util.UUID;

import com.infoacademy.infoacademy.domaine.entities.Course;

public interface GroupService {
    Set<Course> getCoursesByGroup(UUID idGroup);
}
