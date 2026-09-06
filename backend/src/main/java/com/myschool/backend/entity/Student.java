package com.myschool.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDate ;


 @Entity
 @Table(name = "students")
public class Student {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String admissionNumber ;

     private String fullName ;

     private LocalDate dateOFBirth ;

     private String gender ;

     private String className ;

     private String section ;

     private String fatherName ;

     private String motherName ;

     private String phoneNumber ;

     private String profilePhotoUrl ;

     private LocalDate admissionDate ;



}
