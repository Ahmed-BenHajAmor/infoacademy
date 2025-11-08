package com.infoacademy.infoacademy.services.implimentations;

import com.infoacademy.infoacademy.domaine.entities.Homework;
import com.infoacademy.infoacademy.domaine.entities.HomeworkSubmission;
import com.infoacademy.infoacademy.domaine.entities.Student;
import com.infoacademy.infoacademy.domaine.entities.keys.HomeworkSubmissionId;
import com.infoacademy.infoacademy.repositories.HomeworkRepository;
import com.infoacademy.infoacademy.repositories.HomeworkSubmissionRepository;
import com.infoacademy.infoacademy.repositories.StudentRepository;
import com.infoacademy.infoacademy.services.HomeworkService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkRepository homeworkRepository;
    private final StudentRepository studentRepository;
    private final HomeworkSubmissionRepository homeworkSubmissionRepository;

    @Override
    @Transactional
    public void submitHomework(UUID idHomework, UUID idStudent, MultipartFile pdfFile) throws IOException {
        if(!studentRepository.existsById(idStudent) ||
                !homeworkRepository.existsById(idHomework) ||
                !"application/pdf".equals(pdfFile.getContentType()))
            throw new BadRequestException("Bad submition !!");
        Homework homework = homeworkRepository.getReferenceById(idHomework);
        Student student = studentRepository.getReferenceById(idStudent);

        HomeworkSubmission newHomeworkSubmission = HomeworkSubmission.builder()
                .id(new HomeworkSubmissionId(student.getId(), homework.getId()))
                .homework(homework)
                .student(student)
                .submittedFile(pdfFile.getBytes())
                .build();

        homeworkSubmissionRepository.save(newHomeworkSubmission);
    }
}
