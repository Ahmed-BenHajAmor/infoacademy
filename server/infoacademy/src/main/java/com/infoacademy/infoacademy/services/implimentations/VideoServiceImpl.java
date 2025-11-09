package com.infoacademy.infoacademy.services.implimentations;

import com.infoacademy.infoacademy.domaine.entities.Professor;
import com.infoacademy.infoacademy.domaine.entities.Video;
import com.infoacademy.infoacademy.repositories.VideoRepository;
import com.infoacademy.infoacademy.services.ProfessorService;
import com.infoacademy.infoacademy.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final ProfessorService professorService;
    private final VideoRepository repo;
    @Override
    public Video uploadVideo(UUID idProfessor, UUID idGroup, Video videoWithoutProfessorAttribute) throws BadRequestException {
        if(!professorService.isProfessorInGroup(idProfessor, idGroup)){
            throw  new BadRequestException("You don't have access to group with id "+idGroup.toString());
        }
        Professor professor = professorService.getProfessorById(idProfessor);
        videoWithoutProfessorAttribute.setProfessor(professor);
        return repo.save(videoWithoutProfessorAttribute);
    }
}
