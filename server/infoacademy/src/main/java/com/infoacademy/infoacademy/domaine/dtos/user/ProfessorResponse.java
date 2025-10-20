package com.infoacademy.infoacademy.domaine.dtos.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorResponse extends UserResponse{
    private String speciality;
    private String bio;
    private String institution;
    private String profilePicture;
}
