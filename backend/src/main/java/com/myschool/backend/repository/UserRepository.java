package com.myschool.backend.repository;

import com.myschool.backend.entity.Role;
import com.myschool.backend.entity.School;
import com.myschool.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLoginId(String loginId);

    boolean existsByLoginId(String loginId);

    Optional<User> findByRole(Role role);

    Optional<User> findBySchool(School school);

    Optional<User> findByLoginIdAndRoleAndSchool(
            String loginId,
            Role role,
            School school
    );

    boolean existsByLoginIdAndSchool(String loginId, School school);
}