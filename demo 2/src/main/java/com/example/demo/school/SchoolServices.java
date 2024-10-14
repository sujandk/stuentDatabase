package com.example.demo.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolServices {

    private final SchoolRepository schoolRepository;

    private final SchoolMapper schoolMapper;

    public SchoolServices(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }


    public SchoolDto create(
             SchoolDto dto
    ){
        var school = schoolMapper.toSchool(dto);
        var savedSchool=  schoolRepository.save(school);
        return schoolMapper.toSchoolDto(savedSchool);
    }


    public SchoolDto getSchool(
            Integer id
    ){
        var school=  schoolRepository.findById(id).orElse(new School());
        return  schoolMapper.toSchoolDto(school);
    }

    public List<SchoolDto> getSchool(

    ){
        var allSchoolsReturn= schoolRepository.findAll();
        return allSchoolsReturn.stream().map(schoolMapper :: toSchoolDto).collect(Collectors.toList());

    }

}
