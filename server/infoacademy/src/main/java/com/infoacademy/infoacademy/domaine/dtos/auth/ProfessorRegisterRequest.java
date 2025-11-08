package com.infoacademy.infoacademy.domaine.dtos.auth;


import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorRegisterRequest {
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 30, message = "Firstname must be between 3 and 30 characters")
    private String firstname;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 30, message = "Lastname must be between 3 and 30 characters")
    private String lastname;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must contain at least 8 characters")
    private String password;

    @NotBlank(message = "Speciality is required")
    @Size(max = 100, message = "Speciality must not exceed 100 characters")
    private String speciality;

    @Size(max = 255, message = "Bio must not exceed 255 characters")
    private String bio;

    @NotBlank(message = "Institution is required")
    @Size(max = 150, message = "Institution name must not exceed 150 characters")
    private String institution;

    @Pattern(
            regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$",
            message = "Profile picture must be a valid URL"
    )
    private String profilePicture;
}
