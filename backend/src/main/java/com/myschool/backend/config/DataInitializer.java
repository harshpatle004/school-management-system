package com.myschool.backend.config;

import com.myschool.backend.entity.Role;
import com.myschool.backend.repository.UserRepository;
import com.myschool.backend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserService userService;

    public DataInitializer(
            UserRepository userRepository,
            UserService userService
    ) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public void run(String... args) {

        if (userRepository.findByLoginId("superadmin").isEmpty()) {

            userService.createUser(
                    "superadmin",
                    "Harshu@123",
                    Role.SUPER_ADMIN,
                    null
            );

            System.out.println("SUPER_ADMIN created successfully.");
        }
    }
}