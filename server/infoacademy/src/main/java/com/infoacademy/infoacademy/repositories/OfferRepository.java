package com.infoacademy.infoacademy.repositories;

import com.infoacademy.infoacademy.domaine.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {
    Set<Offer> findByIsActive(boolean status);
    boolean existsByTitle(String title);
}
