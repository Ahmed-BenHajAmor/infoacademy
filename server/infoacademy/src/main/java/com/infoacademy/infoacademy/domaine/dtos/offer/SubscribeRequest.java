package com.infoacademy.infoacademy.domaine.dtos.offer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscribeRequest {
    private UUID idOffer;
}
