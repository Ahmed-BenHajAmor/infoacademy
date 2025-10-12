package com.infoacademy.infoacademy.domain.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "professors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professor {

    @Id
    private Long idProfessor; // même que User.idUser

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_user")
    private User user;

    private String speciality;
    private String bio;
    private String institution;
    private String profilePicture;
    private Double rating;
}
