package com.infoacademy.infoacademy.services.implimentations;

import com.infoacademy.infoacademy.domaine.entities.Student;
import com.infoacademy.infoacademy.repositories.StudentRepository;
import com.infoacademy.infoacademy.security.InfoAcademyUserDetailsService;
import com.infoacademy.infoacademy.services.AuthService;
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
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Value("ahmed-a-a-a-d-dddjkhdkjqhdqs")
    private final String secret;

    @Override
    public void studentRegister(Student student) {
        if(studentRepository.existsByUserEmail(student.getUser().getEmail())){
            throw new EntityExistsException("Registration Failed !!");
        }
        student.getUser().setPassword(passwordEncoder.encode(student.getUser().getPassword()));
        studentRepository.save(student);
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
        Map<String, Object> claims = new HashMap();
        return Jwts.builder()
                .signWith(this.getSignKey(), SignatureAlgorithm.ES256)
                .claims(claims)
                .setSubject(userDetails.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .compact();
    }

    private Key getSignKey(){
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}
