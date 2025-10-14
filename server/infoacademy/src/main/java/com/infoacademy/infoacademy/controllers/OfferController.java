package com.infoacademy.infoacademy.controllers;

import com.infoacademy.infoacademy.domaine.dtos.offer.OfferResponse;
import com.infoacademy.infoacademy.domaine.entities.Offer;
import com.infoacademy.infoacademy.domaine.mappers.OfferMapper;
import com.infoacademy.infoacademy.services.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/v1/offer")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService service;
    private final OfferMapper mapper;

    @GetMapping
    public ResponseEntity<Set<OfferResponse>> getOffers(){

        Set<Offer> activeOffers = service.getOffers();
        Set<OfferResponse> activeOffersResponse = activeOffers.stream().map(mapper::toOfferResponse).collect(Collectors.toSet());
        return ResponseEntity.status(HttpStatus.OK).body(activeOffersResponse);
    }
}
