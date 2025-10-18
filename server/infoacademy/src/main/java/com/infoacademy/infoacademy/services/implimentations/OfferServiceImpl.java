package com.infoacademy.infoacademy.services.implimentations;


import com.infoacademy.infoacademy.domaine.entities.Offer;
import com.infoacademy.infoacademy.repositories.OfferRepository;
import com.infoacademy.infoacademy.services.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository repo;

    public Set<Offer> getOffers(){
        Set<Offer> activeOffers = repo.findByIsActive(true);
        return activeOffers;
    }
}
