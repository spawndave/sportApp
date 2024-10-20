package com.academy.sportApp.repository;

import com.academy.sportApp.model.entity.Sport;
import com.academy.sportApp.model.repository.ActivityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ActivityRepositoryTest {

    @Autowired
    private ActivityRepository activityRepository;

    @Test
    public void saveActivityTest(){
        Sport sport = new Sport();
        sport.setName("SportTest");
        sport.setDescription("sport description");
        Sport savedActivity = activityRepository.save(sport);
        Assertions.assertEquals(sport.getName(), savedActivity.getName());
    }
}