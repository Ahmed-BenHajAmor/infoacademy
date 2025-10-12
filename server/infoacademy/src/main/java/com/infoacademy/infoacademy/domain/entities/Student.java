package com.infoacademy.infoacademy.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    private Long idStudent;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_user")
    private User user;

    private String level;
    private String school;
    private LocalDate dateOfBirth;
    private String profilePicture;
    private Integer points;
}
