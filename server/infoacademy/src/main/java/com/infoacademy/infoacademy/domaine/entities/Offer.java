package com.infoacademy.infoacademy.domaine.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "offers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOffer;

    private String title;

    @Lob
    private String description;

    private BigDecimal price;
    private int durationDays;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isActive;



    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "offers")
    private Set<Student> students = new HashSet<>();



    @OneToMany(mappedBy = "offer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Group> groups = new HashSet<>();
}
