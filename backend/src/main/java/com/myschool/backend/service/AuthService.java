package com.myschool.backend.service;

import com.myschool.backend.repository.UserRepository;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private String generatePassword() {

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        Random random = new Random();

        StringBuilder password = new StringBuilder();


        for (int i = 0; i < 4; i++) {
            password.append(letters.charAt(random.nextInt(letters.length())));
        }


        password.append("@");


        for (int i = 0; i < 4; i++) {
            password.append(numbers.charAt(random.nextInt(numbers.length())));
        }

        return password.toString();
    }

        void createUser(){
            String password = generatePassword();

            String encodedPassword = passwordEncoder.encode(password);

        }



}