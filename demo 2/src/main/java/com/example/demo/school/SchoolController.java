package com.example.demo.school;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolServices schoolServices;

    public SchoolController(SchoolServices schoolServices) {
        this.schoolServices = schoolServices;
    }

    @PostMapping("/creates-school")
    public SchoolDto create(
        @Valid @RequestBody  SchoolDto dto
    ){

        return schoolServices.create(dto);
    }



    @GetMapping("/gets-school/{school_id}")
    public SchoolDto getSchool(
            @PathVariable("school_id") Integer id
    ){

        return  schoolServices.getSchool(id);
    }

    @GetMapping("/gets-all-school")
    public List<SchoolDto> getSchool(

    ){
       return schoolServices.getSchool();

    }
}
