package com.infoacademy.infoacademy.services.implimentations;

import com.infoacademy.infoacademy.domaine.entities.Professor;
import com.infoacademy.infoacademy.domaine.entities.Student;
import com.infoacademy.infoacademy.repositories.ProfessorRepository;
import com.infoacademy.infoacademy.repositories.StudentRepository;
import com.infoacademy.infoacademy.services.AuthService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Value("ahmed-ben-haj-amoraddsdqdsdqdqdqdqdqsdqd")
    private String secretKey;

    @Override
    public void studentRegister(Student student) {
        if(studentRepository.existsByUserEmail(student.getUser().getEmail())){
            throw new EntityExistsException("Registration Failed !!");
        }
        student.getUser().setPassword(passwordEncoder.encode(student.getUser().getPassword()));
        studentRepository.save(student);
    }
    @Override
    public void professorRegister(Professor professor) {
        if(professorRepository.existsByUserEmail(professor.getUser().getEmail())){
            throw new EntityExistsException("Registration Failed !!");
        }
        professor.getUser().setPassword(passwordEncoder.encode(professor.getUser().getPassword()));
        professorRepository.save(professor);
    }
    @Override
    public UserDetails authenticate(String email, String password) {
         authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(email, password)
         );

         return userDetailsService.loadUserByUsername(email);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 5 minutes
                .signWith(this.getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public UserDetails verifyToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(this.getSignKey()) // same signing key
                .build()
                .parseClaimsJws(token)
                .getBody(); // instead of getPayload()
        return userDetailsService.loadUserByUsername(claims.getSubject());
    }



    private Key getSignKey(){
        byte[] byteSecretKey = secretKey.getBytes();
        return Keys.hmacShaKeyFor(byteSecretKey);
    }
}
