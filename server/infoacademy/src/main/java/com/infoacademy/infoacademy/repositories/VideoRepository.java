package com.infoacademy.infoacademy.repositories;

import com.infoacademy.infoacademy.domaine.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VideoRepository extends JpaRepository<Video, UUID> {
}
