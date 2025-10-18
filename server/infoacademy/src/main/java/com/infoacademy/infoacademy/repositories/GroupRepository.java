package com.infoacademy.infoacademy.repositories;

import com.infoacademy.infoacademy.domaine.entities.Course;
import com.infoacademy.infoacademy.domaine.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
}
