package com.infoacademy.infoacademy.services;

import java.util.Set;
import java.util.UUID;

import com.infoacademy.infoacademy.domaine.dtos.CourseResponse;

public interface GroupService {
    Set<CourseResponse> getCoursesForGroupInOffer(UUID idGroup, Long idOffer);
}
