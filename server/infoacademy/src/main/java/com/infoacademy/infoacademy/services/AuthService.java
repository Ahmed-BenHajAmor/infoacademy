package com.infoacademy.infoacademy.services;


import com.infoacademy.infoacademy.domaine.entities.Student;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {
    void studentRegister(Student student);
    UserDetails authenticate(String email, String password);
    String generateToken(UserDetails userDetails);
}
