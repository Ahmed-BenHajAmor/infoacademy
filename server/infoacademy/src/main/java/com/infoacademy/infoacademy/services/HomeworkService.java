package com.infoacademy.infoacademy.services;

import org.apache.coyote.BadRequestException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface HomeworkService {
    void submitHomework(UUID idHomework, UUID idStudent, MultipartFile pdfFile) throws IOException;
}
