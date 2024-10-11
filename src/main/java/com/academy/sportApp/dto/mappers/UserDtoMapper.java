package com.academy.sportApp.dto.mappers;

import com.academy.sportApp.dto.UserDto;
import com.academy.sportApp.model.entity.User;
import com.academy.sportApp.model.repository.RoleRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@RequiredArgsConstructor
@Getter
@Component
public class UserDtoMapper implements Function<User, UserDto> {
    private final RoleRepository roleRepository;
    @Override
    public UserDto apply(User user) {

        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                ( user.getFirstName() + user.getLastName() ),
                user.getDateOfBirth(),
                user.getRole()
        );
    }

}