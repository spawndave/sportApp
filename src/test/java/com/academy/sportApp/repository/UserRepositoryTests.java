package com.academy.sportApp.repository;

import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.entity.Coach;
import com.academy.sportApp.model.entity.User;
import com.academy.sportApp.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void saveNewAthleteTest(){
        Athlete athlete = new Athlete();
        athlete.setFirstName("John");
        athlete.setLastName("Doe");
        athlete.setUsername("johndoe");
        athlete.setEmail("john@doe.com");
        athlete.setPassword("1111");
        Athlete savedUser = userRepository.save(athlete);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void getAllUsersTest(){
        Athlete athlete = new Athlete();
        athlete.setFirstName("John");
        athlete.setLastName("Doe");
        athlete.setUsername("johndoe");
        athlete.setEmail("john@doe.com");
        athlete.setPassword("1111");

        Coach coach = new Coach();
        coach.setFirstName("Jenny");
        coach.setLastName("Doe");
        coach.setUsername("jennydoe");
        coach.setEmail("jenn@doe.com");
        coach.setPassword("1111");

        userRepository.save(athlete);
        userRepository.save(coach);

        List<User> users = userRepository.findAll();

        assertThat(users).isNotNull();
        assertThat(users.size()).isEqualTo(12);
    }

    @Test
    public void getUserByIdTest(){
        Coach coach = new Coach();
        coach.setFirstName("Jenny");
        coach.setLastName("Doe");
        coach.setUsername("jennydoe");
        coach.setEmail("jenn@doe.com");
        coach.setPassword("1111");

        userRepository.save(coach);
        User savedCoach = userRepository.getReferenceById(coach.getId());
        assertThat(savedCoach).isNotNull();
    }

    @Test
    public void updateUserTest(){
        Coach coach = new Coach();
        coach.setFirstName("Jenny");
        coach.setLastName("Doe");
        coach.setUsername("jennydoe");
        coach.setEmail("jenn@doe.com");
        coach.setPassword("1111");

        userRepository.save(coach);
        coach.setFirstName("Angel");
        coach.setLastName("Mur");
        userRepository.save(coach);
        User savedCoach = userRepository.getReferenceById(coach.getId());
        assertThat(savedCoach.getFirstName()).isEqualTo("Angel");
    }

    @Test
    public void deleteUserTest(){
        Coach coach = new Coach();
        coach.setFirstName("Jenny");
        coach.setLastName("Doe");
        coach.setUsername("jennydoe");
        coach.setEmail("jenn@doe.com");
        coach.setPassword("1111");

        userRepository.save(coach);
        userRepository.deleteById(coach.getId());
        Optional<User> deletedUser = userRepository.findById(coach.getId());
        assertThat(deletedUser).isEmpty();
    }


}