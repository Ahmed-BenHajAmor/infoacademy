package com.infoacademy.infoacademy.controllers;

import com.infoacademy.infoacademy.domaine.dtos.offer.CreateOfferRequest;
import com.infoacademy.infoacademy.domaine.dtos.offer.OfferResponse;
import com.infoacademy.infoacademy.domaine.dtos.offer.SubscribeRequest;
import com.infoacademy.infoacademy.domaine.entities.Offer;
import com.infoacademy.infoacademy.domaine.mappers.OfferMapper;
import com.infoacademy.infoacademy.services.OfferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;
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

    @PostMapping
    public ResponseEntity<OfferResponse> createOffer(
            @Valid @RequestBody CreateOfferRequest createOfferRequest,
            @RequestAttribute("id_user") UUID loggedProfessorIn
    ){
        Offer offerToCreate = mapper.toEntity(createOfferRequest);
        Offer createdOffer = service.createOffer(offerToCreate, loggedProfessorIn);
        OfferResponse offerResponse = mapper.toOfferResponse(createdOffer);
        return ResponseEntity.status(HttpStatus.CREATED).body(offerResponse);
    }

//    @PostMapping("/subscribe")
//    public ResponseEntity subscribeToOffer(
//            @RequestBody SubscribeRequest subscribeRequest,
//            @RequestAttribute("id_user") UUID loggedInStudent
//    ){
//
//
//        service.subscribeToOffer(subscribeRequest.getIdOffer(), loggedInStudent);
//
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
