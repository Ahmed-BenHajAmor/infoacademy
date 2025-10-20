package com.infoacademy.infoacademy.domaine.dtos.user;

import com.infoacademy.infoacademy.domaine.entities.enums.Level;
import com.infoacademy.infoacademy.domaine.entities.enums.Section;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse extends UserResponse {
    private Level level;

    private Section section;

    private String school;

    private LocalDate dateOfBirth;

    private String profilePicture;
}
