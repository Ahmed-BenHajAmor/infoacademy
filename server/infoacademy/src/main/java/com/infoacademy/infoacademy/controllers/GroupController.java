package com.infoacademy.infoacademy.controllers;

import com.infoacademy.infoacademy.domaine.dtos.CourseResponse;
import com.infoacademy.infoacademy.services.GroupService;
import com.infoacademy.infoacademy.services.implimentations.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService = null;

    @GetMapping("/{idGroup}/offer/{idOffer}/courses")
    public Set<CourseResponse> getCoursesByGroupAndOffer(
            @PathVariable UUID idGroup,
            @PathVariable Long idOffer
    ) {
        return groupService.getCoursesForGroupInOffer(idGroup, idOffer);
    }
}
