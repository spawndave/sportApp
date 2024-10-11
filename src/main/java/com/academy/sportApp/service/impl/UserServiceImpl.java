package com.academy.sportApp.service.impl;

import com.academy.sportApp.dto.NewUserDto;
import com.academy.sportApp.dto.UserDto;
import com.academy.sportApp.dto.mappers.NewUserDtoMapper;
import com.academy.sportApp.dto.mappers.UserDtoMapper;
import com.academy.sportApp.model.entity.*;
import com.academy.sportApp.model.repository.*;
import com.academy.sportApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor




public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AthleteRepository athleteRepository;
    private final RoleRepository roleRepository;
    private final UserDtoMapper userDtoMapper;
    private final NewUserDtoMapper newUserDtoMapper;
    private final AthleteSportRepository athleteSportRepository;
    private final CoachRepository coachRepository;

    @Override
    public List<UserDto> getUsers() {
        Role admin = Role.builder().id(1L).name("ADMIN").build();
        List<User> users = userRepository.findUsersByRoleNot(admin);
        List<UserDto> usersDto = users
                .stream()
                .map(userDtoMapper)
                .collect(Collectors.toList());
        return usersDto;
    }

    @Override
    public UserDto getUserDtoById(Long id) {
        return userDtoMapper.apply(userRepository.getReferenceById(id));
    }


    @Override
    public void saveUser(NewUserDto userDto) {
        User user = newUserDtoMapper.apply(userDto);
        user = userRepository.save(user);
        if(user instanceof Athlete) {
            AthleteSport athleteSport = new AthleteSport();
            athleteSport.setSport(userDto.getSport());
            Athlete athlete = athleteRepository.getReferenceById(user.getId());
            athleteSport.setAthleteData( athlete );
            athleteSportRepository.save(athleteSport);
        }else if(user instanceof Coach){
            Coach coach = coachRepository.getReferenceById(user.getId());
            coach.setSport(userDto.getSport());
            coachRepository.save(coach);
        }
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.getRolesByIdAfter(1L);
    }



}