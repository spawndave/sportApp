package com.academy.sportApp.service;

import com.academy.sportApp.dto.NewUserDto;
import com.academy.sportApp.dto.UserDto;
import com.academy.sportApp.model.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //List<User> getUsers();
    List<UserDto> getUsers();
    UserDto getUserDtoById(Long id);
    void saveUser(NewUserDto user);
    List<Role> getRoles();
}