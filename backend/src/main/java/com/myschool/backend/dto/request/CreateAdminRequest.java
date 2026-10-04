package com.myschool.backend.dto.request;


import com.myschool.backend.entity.School;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAdminRequest {

    @NotBlank
    private String name ;

    @NotBlank
    private School school;
}
