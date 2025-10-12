package com.infoacademy.infoacademy.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

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

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
