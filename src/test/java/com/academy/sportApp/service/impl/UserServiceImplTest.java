package com.academy.sportApp.service.impl;

import com.academy.sportApp.dto.NewUserDto;
import com.academy.sportApp.dto.mappers.NewUserDtoMapper;
import com.academy.sportApp.dto.mappers.UserDtoMapper;
import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.entity.Role;
import com.academy.sportApp.model.entity.User;
import com.academy.sportApp.model.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

class UserServiceImplTest {


    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private  AthleteRepository athleteRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private UserDtoMapper userDtoMapper;
    @Mock
    private NewUserDtoMapper newUserDtoMapper;
    @Mock
    private AthleteSportRepository athleteSportRepository;
    @Mock
    private CoachRepository coachRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUsers() {
    }

    @Test
    void getUserDtoById() {
    }

    @Test
    void saveUser() {
        Role role = new Role(3L, "ATHLETE", List.of());
        NewUserDto userDto = new NewUserDto();
        userDto.setUsername("johndoe");
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setEmail("john.doe@asd.qw");
        userDto.setDateOfBirth(LocalDate.now());
        userDto.setRole(role);
        userDto.setPassword("1111");

        User user = new Athlete();
        user.setUsername("johndoe");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@asd.qw");
        user.setDateOfBirth(LocalDate.now());
        user.setRole(role);
        user.setPassword("1111");

        when(newUserDtoMapper.apply(userDto)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.saveUser(userDto);

        Assertions.assertEquals(userDto.getUsername(), savedUser.getUsername());
        Assertions.assertEquals(userDto.getEmail(), savedUser.getEmail());
        Assertions.assertEquals(userDto.getRole(), savedUser.getRole());


    }

    @Test
    void getUserByUsername() {
    }

    @Test
    void updateUserData() {
    }

    @Test
    void userWithEmailExists() {
    }

    @Test
    void userWithUsernameExists() {
    }
}