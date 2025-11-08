package com.infoacademy.infoacademy.services;

import com.infoacademy.infoacademy.domaine.entities.Offer;

import java.util.Set;
import java.util.UUID;

public interface OfferService {
    Set<Offer> getOffers();
    Offer createOffer(Offer offer, UUID loggedProfessorIn);

    void subscribeToOffer(UUID idOffer, UUID idStudent);
}
