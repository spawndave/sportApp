package com.academy.sportApp.service;

import com.academy.sportApp.dto.NewUserDto;
import com.academy.sportApp.dto.UserDto;
import com.academy.sportApp.dto.mappers.NewUserDtoMapper;
import com.academy.sportApp.dto.mappers.UserDtoMapper;
import com.academy.sportApp.model.entity.*;
import com.academy.sportApp.model.repository.CoachRepository;
import com.academy.sportApp.model.repository.UserRepository;
import com.academy.sportApp.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private CoachRepository coachRepository;
    @Mock
    private NewUserDtoMapper newUserDtoMapper;
    @Mock
    private UserDtoMapper userDtoMapper;
    @Mock
    private Sport sport;

    private Coach coach;
    private UserDto userDto;
    private NewUserDto newUserDto;
    private Role role;

    @BeforeEach
    void setUp() {
        role = new Role(2L, "COACH", List.of());
        newUserDto = new NewUserDto();
        newUserDto.setUsername("johndoe");
        newUserDto.setFirstName("John");
        newUserDto.setLastName("Doe");
        newUserDto.setEmail("john.doe@asd.qw");
        newUserDto.setDateOfBirth(LocalDate.now());
        newUserDto.setRole(role);
        newUserDto.setSport(sport);
        newUserDto.setPassword("1111");

        coach = new Coach();
        coach.setId(1L);
        coach.setUsername("johndoe");
        coach.setFirstName("John");
        coach.setLastName("Doe");
        coach.setEmail("john.doe@asd.qw");
        coach.setSport(sport);
        coach.setDateOfBirth(LocalDate.now());
        coach.setRole(role);
        coach.setPassword("1111");

        userDto = new UserDto(1L, "johndoe","John", "Doe","john.doe@asd.qw",LocalDate.now(), role);
    }

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void saveUserTest(){

        when(newUserDtoMapper.apply(any(NewUserDto.class))).thenReturn(coach);
        when(userRepository.save(any(User.class))).thenReturn(coach);
        when(coachRepository.getReferenceById(1L)).thenReturn(coach);
        when(coachRepository.save(coach)).thenReturn(coach);

        User savedUser = userService.saveUser(newUserDto);

        assertEquals(newUserDto.getUsername(), savedUser.getUsername());
        assertEquals(newUserDto.getEmail(), savedUser.getEmail());
        assertEquals(newUserDto.getRole(), savedUser.getRole());
    }

    @Test
    public void getUsersTest(){
        List<User> users = List.of(new Coach(), new Athlete());

        when(userRepository.findUsersByRoleNot(any(Role.class))).thenReturn(users);
        when(userDtoMapper.apply(any(User.class))).thenReturn(userDto);

        List<UserDto> usersDto = userService.getUsers();
        assertEquals(users.size(), usersDto.size());
    }
}