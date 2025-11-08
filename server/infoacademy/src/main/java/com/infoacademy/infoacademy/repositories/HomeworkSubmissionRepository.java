package com.infoacademy.infoacademy.repositories;

import com.infoacademy.infoacademy.domaine.entities.HomeworkSubmission;
import com.infoacademy.infoacademy.domaine.entities.keys.HomeworkSubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HomeworkSubmissionRepository extends JpaRepository<HomeworkSubmission, HomeworkSubmissionId> {
}
