package com.myschool.backend.service;


import com.myschool.backend.dto.CreateSchoolRequest;
import com.myschool.backend.entity.School;
import com.myschool.backend.repository.SchoolRepository;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository ;



    public SchoolService(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository ;

    }

    public School createSchool(CreateSchoolRequest request){

     if(!schoolRepository.existsBySchoolId(request.getSchoolId())){

         throw new RuntimeException("School id already exists");

     }

     if(!schoolRepository.existsByUdiseCode(request.getUdiseCode())){
         throw new RuntimeException("Udise already exists") ;
     }

     School school = new School();

     school.setSchoolId(request.getSchoolId());
     school.setName(request.getName());
     school.setPhoneNumber(request.getPhoneNumber());
     school.setAddress(request.getAddress());
     school.setUdiseCode(request.getUdiseCode());

     return schoolRepository.save(school);
}
