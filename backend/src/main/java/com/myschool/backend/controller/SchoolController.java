package com.myschool.backend.controller;

import com.myschool.backend.dto.CreateSchoolRequest;
import com.myschool.backend.entity.School;
import com.myschool.backend.service.SchoolService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PostMapping("/create")
    public School createSchool(
            @RequestBody CreateSchoolRequest request
    ) {
        return schoolService.createSchool(request);
    }
}