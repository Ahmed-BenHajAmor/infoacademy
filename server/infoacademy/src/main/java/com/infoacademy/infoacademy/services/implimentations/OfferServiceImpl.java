package com.infoacademy.infoacademy.services.implimentations;


import com.infoacademy.infoacademy.domaine.entities.Offer;
import com.infoacademy.infoacademy.domaine.entities.Professor;
import com.infoacademy.infoacademy.domaine.entities.Student;
import com.infoacademy.infoacademy.repositories.OfferRepository;
import com.infoacademy.infoacademy.repositories.ProfessorRepository;
import com.infoacademy.infoacademy.repositories.StudentRepository;
import com.infoacademy.infoacademy.repositories.UserRepository;
import com.infoacademy.infoacademy.services.OfferService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository repo;
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final OfferRepository offerRepository;

    public Set<Offer> getOffers(){
        return repo.findByIsActive(true);
    }

    @Override
    @Transactional
    public Offer createOffer(Offer offer, UUID loggedProfessorIn) {
        if(repo.existsByTitle(offer.getTitle())){
            throw new IllegalArgumentException("Offer exists !!");
        }
        Professor creator =  professorRepository.findById(loggedProfessorIn).orElseThrow(()->new EntityNotFoundException("Professor trying to create the offer not found !!"));
        offer.setCreator(creator);
        return repo.save(offer);
    }

    @Override
    @Transactional
    public void subscribeToOffer(UUID idOffer, UUID idStudent) {
        Offer offer = offerRepository.findById(idOffer)
                .orElseThrow(()->new EntityNotFoundException("Offer you're trying to subscribe not found !!"));

        Student student = studentRepository.findById(idStudent)
                .orElseThrow(()->new EntityNotFoundException("Student not found !!"));


        student.getOffers().add(offer);
        studentRepository.save(student);

    }
}
