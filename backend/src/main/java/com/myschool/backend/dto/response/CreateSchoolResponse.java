package com.myschool.backend.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateSchoolResponse {

    private String school_id;

    @NotBlank
    private String name;

    private String address;

    private String phoneNumber;

    @NotBlank
    private String udiseCode;
}
