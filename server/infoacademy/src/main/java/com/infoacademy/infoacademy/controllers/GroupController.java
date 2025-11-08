package com.infoacademy.infoacademy.controllers;

import com.infoacademy.infoacademy.domaine.dtos.course.CourseResponse;
import com.infoacademy.infoacademy.domaine.dtos.homework.HomeworkResponse;
import com.infoacademy.infoacademy.domaine.dtos.video.VideoResponse;
import com.infoacademy.infoacademy.domaine.mappers.CourseMapper;
import com.infoacademy.infoacademy.domaine.mappers.HomeworkMapper;
import com.infoacademy.infoacademy.domaine.mappers.VideoMapper;
import com.infoacademy.infoacademy.services.GroupService;
import com.infoacademy.infoacademy.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {

    private final GroupService service;
    private final CourseMapper courseMapper;
    private final VideoMapper videoMapper;
    private final HomeworkMapper homeworkMapper;
    private final UserService userService;

    @GetMapping("/{idGroup}/courses")
    public Set<CourseResponse> getGroupCourses(
            @PathVariable UUID idGroup,
            @RequestAttribute("id_user") UUID idLoggedInUser
    ) throws BadRequestException {
        if(userService.isUserInGroup(idLoggedInUser, idGroup))
            throw new BadRequestException("You don't have access to group with id"+idGroup.toString());
        return service.getGroupCourses(idGroup).stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toSet());
    }

    @GetMapping("/{idGroup}/videos")
    public Set<VideoResponse> getGroupVideos(
            @PathVariable UUID idGroup,
            @RequestAttribute("id_user") UUID idLoggedInUser
    ) throws BadRequestException {
        if(userService.isUserInGroup(idLoggedInUser, idGroup))
            throw new BadRequestException("You don't have access to group with id"+idGroup.toString());
        return service.getGroupVideos(idGroup).stream()
                .map(videoMapper::toDto)
                .collect(Collectors.toSet());
    }

    @GetMapping("/{idGroup}/homeworks")
    public Set<HomeworkResponse> getGroupHomeworks(
            @PathVariable UUID idGroup,
            @RequestAttribute("id_user") UUID idLoggedInUser
    ) throws BadRequestException {
        if(userService.isUserInGroup(idLoggedInUser, idGroup))
            throw new BadRequestException("You don't have access to group with id"+idGroup.toString());
        return service.getGroupHomeworks(idGroup).stream()
                .map(homeworkMapper::toDto)
                .collect(Collectors.toSet());
    }


}
