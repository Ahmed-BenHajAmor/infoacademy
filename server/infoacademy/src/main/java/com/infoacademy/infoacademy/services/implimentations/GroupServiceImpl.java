package com.infoacademy.infoacademy.services.implimentations;

import com.infoacademy.infoacademy.domaine.dtos.CourseResponse;
import com.infoacademy.infoacademy.domaine.entities.Course;
import com.infoacademy.infoacademy.repositories.GroupRepository;
import com.infoacademy.infoacademy.services.GroupService;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository = null;

    @Override
    public Set<CourseResponse> getCoursesForGroupInOffer(UUID idGroup, Long idOffer) {
        Set<Course> courses = groupRepository.findCoursesByGroupAndOffer(idGroup, idOffer);

        if (courses == null || courses.isEmpty()) {
            throw new IllegalArgumentException("Aucun cours trouvé pour ce groupe et cette offre.");
        }

        return courses.stream()
                .map(course -> new CourseResponse(
                        course.getTitle(),
                        course.getThumbnailUrl()
                ))
                .collect(Collectors.toSet());
    }
}
