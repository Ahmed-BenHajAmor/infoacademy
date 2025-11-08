package com.infoacademy.infoacademy.services;

import com.infoacademy.infoacademy.domaine.entities.User;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface UserService {
    User getUserById(UUID idUser);
    boolean isUserInGroup(UUID idUser, UUID idGroup);
}
