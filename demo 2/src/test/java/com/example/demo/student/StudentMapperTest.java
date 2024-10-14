package com.example.demo.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper= new StudentMapper();
    }

    @Test
    public void shouldTestStudentResponseDto(){
        Student student = new Student("Sujan", "sujan@gmail.com", "Dhakal" , 23);
        StudetResponseDto dto = mapper.studetResponseDto(student);
        assertEquals(student.getName() , dto.name());
        assertEquals(student.getEmail() , dto.email());
        assertEquals(student.getLastName() , dto.LastName());

    }

    @Test
    public void shouldTestToStudent(){
        StudentDto studentDto = new StudentDto("Sujan", "sujan@gmail.com", "Dhakal" , 1);
        Student student = mapper.toStudent(studentDto);
        assertEquals(student.getName() , studentDto.name());
        assertEquals(student.getEmail() , studentDto.email());
        assertEquals(student.getLastName() , studentDto.LastName());
        assertNotNull(student.getSchool());
        assertEquals(student.getSchool().getId(), studentDto.schoolId());

    }


}