package com.academy.sportApp.service.impl;

import com.academy.sportApp.model.entity.User;
import com.academy.sportApp.model.repository.UserRepository;
import com.academy.sportApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }


}
