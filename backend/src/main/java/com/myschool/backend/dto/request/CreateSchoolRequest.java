package com.myschool.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSchoolRequest {



    @NotBlank
    private String name;

    private String address;

    private String phoneNumber;

    @NotBlank
    private String udiseCode;
}