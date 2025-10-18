package com.infoacademy.infoacademy.repositories;

import com.infoacademy.infoacademy.domaine.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    boolean existsByUserEmail(String email);
}
