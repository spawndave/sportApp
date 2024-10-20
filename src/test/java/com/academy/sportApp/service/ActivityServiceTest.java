package com.academy.sportApp.service;

import com.academy.sportApp.model.entity.Sport;
import com.academy.sportApp.model.repository.ActivityRepository;
import com.academy.sportApp.model.repository.SportRepository;
import com.academy.sportApp.service.impl.ActivityServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActivityServiceTest {

    @Mock
    private ActivityRepository activityRepository;
    @Mock
    private SportRepository sportRepository;

    @InjectMocks
    private ActivityServiceImpl activityService;

    @Test
    public void getActivitiesTest(){
        List<Sport> sports = List.of(new Sport());

        when(activityRepository.findAll()).thenReturn(sports);
        List<Sport>savedActivities = activityService.getActivities();
        assertEquals(savedActivities.size(), sports.size());
    }

    @Test
    public void getSportByNameTest(){
        Sport sport = new Sport();
        sport.setName("Football");
        when(sportRepository.getSportByName(any(String.class))).thenReturn(sport);

        Sport savedSport = activityService.getSportByName("Football");
        assertEquals(savedSport.getName(), sport.getName());
    }
}