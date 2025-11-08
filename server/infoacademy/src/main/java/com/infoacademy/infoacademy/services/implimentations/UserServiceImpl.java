package com.infoacademy.infoacademy.services.implimentations;

import com.infoacademy.infoacademy.domaine.entities.Group;
import com.infoacademy.infoacademy.domaine.entities.Student;
import com.infoacademy.infoacademy.domaine.entities.User;
import com.infoacademy.infoacademy.domaine.entities.enums.Role;
import com.infoacademy.infoacademy.repositories.StudentRepository;
import com.infoacademy.infoacademy.repositories.UserRepository;
import com.infoacademy.infoacademy.services.GroupService;
import com.infoacademy.infoacademy.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final GroupService groupService;

    @Override
    public User getUserById(UUID idUser) {
        return userRepository.findById(idUser).orElseThrow(()-> new EntityNotFoundException("user do not exist !!"));
    }

    @Override
    @Transactional
    public boolean isUserInGroup(UUID idUser, UUID idGroup) {
        User user = this.getUserById(idUser);
        Group group = groupService.getGroupById(idGroup);
        if(Role.STUDENT.equals(user.getRole())){
            Student student = studentRepository.findById(idUser).orElseThrow(()-> new EntityNotFoundException("student do not exist !!"));
            Set<Group> studentGroups = student.getGroups();
            return !studentGroups.contains(group);
        }
        return true;


    }
}
