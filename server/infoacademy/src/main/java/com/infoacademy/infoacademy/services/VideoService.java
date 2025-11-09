package com.infoacademy.infoacademy.services;

import com.infoacademy.infoacademy.domaine.entities.Video;
import org.apache.coyote.BadRequestException;

import java.util.UUID;

public interface VideoService {
    Video uploadVideo(UUID idProfessor, UUID idGroup, Video videoWithoutProfessorAttribute) throws BadRequestException;
}
