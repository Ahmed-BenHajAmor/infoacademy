package com.infoacademy.infoacademy.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoacademy.infoacademy.domaine.dtos.Error.ErrorResponse;
import com.infoacademy.infoacademy.services.AuthService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final AuthService authService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = request.getHeader("Authorization");
            if(token != null && token.startsWith("Bearer ")){
                token = token.substring(7);
                UserDetails userDetails = authService.verifyToken(token);
                System.out.println(userDetails.getAuthorities());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
                if(userDetails instanceof InfoAcademyUserDetails){
                    UUID idUser = ((InfoAcademyUserDetails) userDetails).getId();
                    request.setAttribute("id_user", idUser);
                }

            }
        }catch (Exception e){
            response.setStatus(HttpStatus.FORBIDDEN.value());
            ErrorResponse error = ErrorResponse.builder()
                    .status(HttpStatus.FORBIDDEN.value())
                    .message(e.getMessage())
                    .build();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(error);
            response.setContentType("application/json");
            response.getWriter().write(json);
            response.getWriter().flush();


            log.warn("not auth : "+e.getMessage());
            return;
        }

        filterChain.doFilter(request, response);

    }
}
