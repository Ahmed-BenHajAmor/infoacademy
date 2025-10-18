package com.infoacademy.infoacademy.services.implimentations;

import com.infoacademy.infoacademy.domaine.entities.Course;
import com.infoacademy.infoacademy.domaine.entities.Group;
import com.infoacademy.infoacademy.repositories.GroupRepository;
import com.infoacademy.infoacademy.services.GroupService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository = null;

    @Override
    public Set<Course> getCoursesByGroup(UUID idGroup) {
        Group group = groupRepository.findById(idGroup).orElseThrow(()->new EntityNotFoundException("Aucun cours trouvé pour ce groupe"));
        Set<Course> courses = group.getCourses();
        return courses;
    }
}
