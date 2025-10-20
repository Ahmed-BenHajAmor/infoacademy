package com.infoacademy.infoacademy.services.implimentations;

import com.infoacademy.infoacademy.domaine.entities.Course;
import com.infoacademy.infoacademy.domaine.entities.Group;
import com.infoacademy.infoacademy.domaine.entities.Homework;
import com.infoacademy.infoacademy.domaine.entities.Video;
import com.infoacademy.infoacademy.repositories.GroupRepository;
import com.infoacademy.infoacademy.services.GroupService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;


@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    @Transactional
    public Set<Course> getGroupCourses(UUID idGroup) {
        Group group = groupRepository.findById(idGroup).orElseThrow(()->new EntityNotFoundException("No course Found !!"));
        return group.getCourses();
    }

    @Override
    public Set<Video> getGroupVideos(UUID idGroup) {
        Group group = groupRepository.findById(idGroup).orElseThrow(()->new EntityNotFoundException("No course Found !!"));
        return group.getVideos();
    }

    @Override
    public Set<Homework> getGroupHomeworks(UUID idGroup) {
        Group group = groupRepository.findById(idGroup).orElseThrow(()->new EntityNotFoundException("No course Found !!"));
        return group.getHomeworks();
    }
}
