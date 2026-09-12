package com.myschool.backend.dto;

import com.myschool.backend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {

    private String schoolId;
    private Role role;
    private String loginId;
    private String token;
}