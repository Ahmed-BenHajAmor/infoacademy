package com.infoacademy.infoacademy.domaine.mappers;


import com.infoacademy.infoacademy.domaine.entities.Offer;
import com.infoacademy.infoacademy.domaine.entities.dtos.offer.OfferResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OfferMapper {

    OfferResponse toOfferResponse(Offer offer) ;

}
