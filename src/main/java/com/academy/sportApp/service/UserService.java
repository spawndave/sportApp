package com.academy.sportApp.service;

import com.academy.sportApp.dto.NewUserDto;
import com.academy.sportApp.dto.UserDto;
import com.academy.sportApp.model.entity.Role;
import com.academy.sportApp.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //List<User> getUsers();
    Page<UserDto> getUsers(Pageable page);
    UserDto getUserDtoById(Long id);
    User saveUser(NewUserDto user);
    List<Role> getRoles();
    User getUserByUsername(String username);
    void updateUserData(UserDto user, String username);
    boolean userWithEmailExists(String email);
    boolean userWithUsernameExists(String username);
    UserDto getUserDtoByUsername(String username);
}