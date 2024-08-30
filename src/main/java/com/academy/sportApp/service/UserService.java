package com.academy.sportApp.service;

import com.academy.sportApp.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsers();
}
