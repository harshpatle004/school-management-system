package com.myschool.backend.service;


import com.myschool.backend.entity.Student;
import com.myschool.backend.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository ;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
