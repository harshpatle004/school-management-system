package com.myschool.backend.service;

import com.myschool.backend.entity.Role;
import com.myschool.backend.entity.User;
import com.myschool.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository ;
    private final PasswordEncoder passwordEncoder ;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder ;
    }

    public User CreateUser(String loginId, String password, Role role){

        User user = new User();
        user.setLoginId(loginId);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);

       return  userRepository.save(user);



    }


}
