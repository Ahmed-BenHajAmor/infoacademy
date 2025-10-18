package com.infoacademy.infoacademy.domaine.dtos.auth;


import com.infoacademy.infoacademy.domaine.entities.enums.Level;
import com.infoacademy.infoacademy.domaine.entities.enums.Section;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private UUID id;

    private String firstname;

    private String lastname;

    private String email;


}
