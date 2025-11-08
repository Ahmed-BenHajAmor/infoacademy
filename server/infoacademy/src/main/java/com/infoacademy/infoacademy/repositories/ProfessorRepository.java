package com.infoacademy.infoacademy.repositories;

import com.infoacademy.infoacademy.domaine.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
    boolean existsByUserEmail(String email);
}
