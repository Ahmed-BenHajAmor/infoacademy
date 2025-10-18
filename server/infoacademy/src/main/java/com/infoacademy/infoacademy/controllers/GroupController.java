package com.infoacademy.infoacademy.controllers;

import com.infoacademy.infoacademy.domaine.entities.dtos.CourseResponse;
import com.infoacademy.infoacademy.services.GroupService;

import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/{idGroup}/offer/{idOffer}/courses")
    public Set<CourseResponse> getCoursesByGroup(
            @PathVariable UUID idGroup
    ) {
        return groupService.getCoursesByGroup(idGroup).stream()
                .map(course -> new CourseResponse(
                        course.getTitle(),
                        course.getThumbnailUrl()
                ))
                .collect(Collectors.toSet());
    }
}
