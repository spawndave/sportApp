package com.academy.sportApp.service;

import com.academy.sportApp.model.entity.Sport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {
    List<Sport> getActivities();
}