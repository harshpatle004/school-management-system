package com.myschool.backend.repository;

import com.myschool.backend.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository  extends JpaRepository<School, Long> {

    Optional<School> findBySchoolId(String schoolId);

}
