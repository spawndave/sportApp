package com.academy.sportApp.service.impl;

import com.academy.sportApp.model.entity.Sport;
import com.academy.sportApp.model.repository.ActivityRepository;
import com.academy.sportApp.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private ActivityRepository activityRepository;
    @Override
    public List<Sport> getActivities() {
        return activityRepository.findAll();
    }
}