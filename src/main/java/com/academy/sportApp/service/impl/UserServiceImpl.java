package com.academy.sportApp.service.impl;

import com.academy.sportApp.model.entity.Role;
import com.academy.sportApp.model.entity.User;
import com.academy.sportApp.model.repository.AthleteRepository;
import com.academy.sportApp.model.repository.CoachRepository;
import com.academy.sportApp.model.repository.RoleRepository;
import com.academy.sportApp.model.repository.UserRepository;
import com.academy.sportApp.service.TaskService;
import com.academy.sportApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AthleteRepository athleteRepository;
    private final CoachRepository coachRepository;
    private final RoleRepository roleRepository;
    private final TaskService service;
    /*
    private final RoleRepository roleRepository;
    private final PrivilegeRepository privilegeRepository;

    */

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        service.performTask();
        return users;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }


    @Override
    public void saveUser(User user) {
        userRepository.save(user);

    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getReferenceById(id);
    }


}