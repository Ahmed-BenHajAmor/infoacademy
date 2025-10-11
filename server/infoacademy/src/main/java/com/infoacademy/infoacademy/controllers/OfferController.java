package com.infoacademy.infoacademy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/offer")
public class OfferController {

    @GetMapping
    public ResponseEntity getOffers(){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
