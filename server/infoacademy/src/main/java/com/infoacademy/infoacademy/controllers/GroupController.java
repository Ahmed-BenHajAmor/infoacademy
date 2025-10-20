package com.infoacademy.infoacademy.controllers;

import com.infoacademy.infoacademy.domaine.dtos.course.CourseResponse;
import com.infoacademy.infoacademy.domaine.dtos.homework.HomeworkResponse;
import com.infoacademy.infoacademy.domaine.dtos.video.VideoResponse;
import com.infoacademy.infoacademy.domaine.mappers.CourseMapper;
import com.infoacademy.infoacademy.domaine.mappers.HomeworkMapper;
import com.infoacademy.infoacademy.domaine.mappers.VideoMapper;
import com.infoacademy.infoacademy.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1/groups")
public class GroupController {

    private final GroupService service;
    private final CourseMapper courseMapper;
    private final VideoMapper videoMapper;
    private final HomeworkMapper homeworkMapper;

    @GetMapping("/{idGroup}/courses")
    public Set<CourseResponse> getGroupCourses(
            @RequestParam UUID idGroup
    ) {
        return service.getGroupCourses(idGroup).stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toSet());
    }

    @GetMapping("/{idGroup}/videos")
    public Set<VideoResponse> getGroupVideos(
            @RequestParam UUID idGroup
    ) {
        return service.getGroupVideos(idGroup).stream()
                .map(videoMapper::toDto)
                .collect(Collectors.toSet());
    }

    @GetMapping("/{idGroup}/homeworks")
    public Set<HomeworkResponse> getGroupHomeworks(
            @RequestParam UUID idGroup
    ) {
        return service.getGroupHomeworks(idGroup).stream()
                .map(homeworkMapper::toDto)
                .collect(Collectors.toSet());
    }
}
