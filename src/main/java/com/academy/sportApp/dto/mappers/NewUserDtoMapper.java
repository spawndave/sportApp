package com.academy.sportApp.dto.mappers;

import com.academy.sportApp.dto.NewUserDto;
import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.entity.Coach;
import com.academy.sportApp.model.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@RequiredArgsConstructor
@Getter
@Component
public class NewUserDtoMapper implements Function<NewUserDto, User> {

    private final PasswordEncoder passwordEncoder;
    @Override
    public User apply(NewUserDto userDto) {
        User user;
        if ( userDto.getRole().getName().equals("ATHLETE") ) {
            user= new Athlete();
        } else if( userDto.getRole().getName().equals("COACH") ){
            user= new Coach();
        }else{
            return null;
        }
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());;
        user.setDateOfBirth(userDto.getDateOfBirth());
        return user;
    }
}