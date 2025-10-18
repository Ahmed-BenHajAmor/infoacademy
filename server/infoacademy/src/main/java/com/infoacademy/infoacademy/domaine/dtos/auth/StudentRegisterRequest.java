package com.infoacademy.infoacademy.domaine.dtos.auth;

import com.infoacademy.infoacademy.domaine.entities.enums.Level;
import com.infoacademy.infoacademy.domaine.entities.enums.Section;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRegisterRequest {

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

    @NotNull(message = "Level is required")
    private Level level;

    @NotNull(message = "Section is required")
    private Section section;

    @NotBlank(message = "School name is required")
    @Size(max = 100, message = "School name must not exceed 100 characters")
    private String school;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Pattern(
            regexp = "^(|.*\\.(jpg|jpeg|png|gif|bmp|webp))$",
            message = "Profile picture must be an image file (jpg, jpeg, png, gif, bmp, or webp)"
    )
    private String profilePicture;
}
