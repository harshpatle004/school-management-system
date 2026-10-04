package com.myschool.backend.dto.request;

import com.myschool.backend.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private String schoolId;
    private Role role;
    private String loginId;
    private String password;
}