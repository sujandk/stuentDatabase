package com.example.demo.student;

import com.example.demo.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto){
        var student = new Student();
        student.setEmail(dto.email());
        student.setName(dto.name());
        student.setLastName(dto.LastName());

        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);

        return student;
    }

    public  StudetResponseDto studetResponseDto(Student student){
        return new StudetResponseDto(student.getName(),
                student.getEmail(),
                student.getLastName());
    }
}
