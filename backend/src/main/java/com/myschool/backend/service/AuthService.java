package com.myschool.backend.service;

import com.myschool.backend.dto.CreateUserResponse;
import com.myschool.backend.dto.LoginRequest;
import com.myschool.backend.dto.LoginResponse;
import com.myschool.backend.entity.Role;
import com.myschool.backend.entity.School;
import com.myschool.backend.entity.User;
import com.myschool.backend.repository.SchoolRepository;
import com.myschool.backend.repository.UserRepository;
import com.myschool.backend.security.JwtSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SchoolRepository schoolRepository;
    private final JwtSecurity jwtSecurity;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            SchoolRepository schoolRepository,
            JwtSecurity jwtSecurity
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.schoolRepository = schoolRepository;
        this.jwtSecurity = jwtSecurity;
    }

    private String generateLoginId(Role role, School school) {

        String prefix;

        switch (role) {
            case STUDENT -> prefix = "STU";
            case TEACHER -> prefix = "TEA";
            case STAFF -> prefix = "STF";
            case ADMIN -> prefix = "ADM";
            default -> throw new IllegalArgumentException("Invalid role");
        }

        Random random = new Random();

        String loginId;

        do {
            int number = 10000 + random.nextInt(90000);
            loginId = prefix + number;

        } while (userRepository.existsByLoginId(loginId));

        return loginId;
    }

    private String generatePassword() {

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        Random random = new Random();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            password.append(
                    letters.charAt(random.nextInt(letters.length()))
            );
        }

        password.append("@");

        for (int i = 0; i < 4; i++) {
            password.append(
                    numbers.charAt(random.nextInt(numbers.length()))
            );
        }

        return password.toString();
    }

    public CreateUserResponse createUser(Role role, School school) {

        String loginId = generateLoginId(role, school);

        String password = generatePassword();

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User();

        user.setSchool(school);
        user.setRole(role);
        user.setLoginId(loginId);
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return new CreateUserResponse(
                school.getSchoolId(),
                role,
                loginId,
                password
        );
    }

    public LoginResponse login(LoginRequest request) {

        User user;

        if (request.getRole() == Role.SUPER_ADMIN) {

            user = userRepository
                    .findByLoginIdAndRole(
                            request.getLoginId(),
                            Role.SUPER_ADMIN
                    )
                    .orElseThrow(() ->
                            new RuntimeException("Invalid login credentials")
                    );

        } else {

            School school = schoolRepository
                    .findBySchoolId(request.getSchoolId())
                    .orElseThrow(() ->
                            new RuntimeException("Invalid school ID")
                    );

            user = userRepository
                    .findByLoginIdAndRoleAndSchool(
                            request.getLoginId(),
                            request.getRole(),
                            school
                    )
                    .orElseThrow(() ->
                            new RuntimeException("Invalid login credentials")
                    );
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )) {
            throw new RuntimeException("Invalid login credentials");
        }

        // JWT uses globally unique database User ID
        String token = jwtSecurity.generateToken(user.getId());

        String schoolId = user.getSchool() != null
                ? user.getSchool().getSchoolId()
                : null;

        return new LoginResponse(
                schoolId,
                user.getRole(),
                user.getLoginId(),
                token
        );
    }
}