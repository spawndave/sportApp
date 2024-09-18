package com.academy.sportApp;

import com.academy.sportApp.model.entity.Privilege;
import com.academy.sportApp.model.entity.Role;
import com.academy.sportApp.model.repository.PrivilegeRepository;
import com.academy.sportApp.model.repository.RoleRepository;
import com.academy.sportApp.model.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PrivilegeRepository privilegeRepository;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }

}
