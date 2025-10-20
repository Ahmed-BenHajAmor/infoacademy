package com.infoacademy.infoacademy.services;

import java.util.Set;
import java.util.UUID;

import com.infoacademy.infoacademy.domaine.entities.Course;
import com.infoacademy.infoacademy.domaine.entities.Video;

public interface GroupService {
    Set<Course> getGroupCourses(UUID idGroup);
    Set<Video> getGroupVideos(UUID idGroup);
}
