package com.infoacademy.infoacademy.repositories;

import com.infoacademy.infoacademy.domaine.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
    @Query("SELECT g FROM Group g LEFT JOIN FETCH g.courses WHERE g.id = :idGroup")
    Optional<Group> findByIdWithCourses(@Param("idGroup") UUID idGroup);

    @Query("SELECT g FROM Group g LEFT JOIN FETCH g.videos WHERE g.id = :idGroup")
    Optional<Group> findByIdWithVideos(@Param("idGroup") UUID idGroup);

    @Query("SELECT g FROM Group g LEFT JOIN FETCH g.homeworks WHERE g.id = :idGroup")
    Optional<Group> findByIdWithHomeworks(@Param("idGroup") UUID idGroup);
}
