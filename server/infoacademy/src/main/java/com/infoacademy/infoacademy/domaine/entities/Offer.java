package com.infoacademy.infoacademy.domaine.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "offers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    @Lob
    private String description;

    private BigDecimal price;

    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            nullable = false,
            name = "id_creator"
    )
    private Professor creator;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "offers")
    private Set<Student> students = new HashSet<>();



    @OneToMany(mappedBy = "offer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Group> groups = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(id, offer.id);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
