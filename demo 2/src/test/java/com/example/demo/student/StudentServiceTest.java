package com.example.demo.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;
    @Mock
    private StudentMapper studentMapper;
    @Mock
    private StudentRepository repo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    public void shouldTestPostsStudent(){
//
//        //Given
//        StudentDto  dto = new StudentDto("Sujan", "sujandhakal@gmail.com", "dhakal" , 1);
//
//        //When
//
//        //Then
//
//    }
    @Test
    public  void testsGetsAllStudents(){
        //Given
         List<Student> student = new ArrayList<>();
         student.add(
                 new Student("sujan" , "sujandhakal@gmail.com" , "dhakal", 20)
         );


        //Mock
        Mockito.when(repo.findAll()).thenReturn(student);
        Mockito.when(studentMapper.studetResponseDto(any(Student.class))).thenReturn(
                new StudetResponseDto("sujan", "sujandhakal@gmail.com" , "dhakal")
        );
        //When
        List<StudetResponseDto> responseDto = studentService.getsAllStudents();

        //Then
        assertEquals(student.size(), responseDto.size());


    }

    @Test
    public void testsGetsStudentById(){

        //Given
        Integer id = 1;
        Student student = new Student("sujan", "sujan@gmail.com", "dhakal" , 20);
        student.setId(id);
        StudetResponseDto dto = new StudetResponseDto("sujan", "sujan@gmail.com", "dhakal");


        //Mock
        Mockito.when(repo.findById(id)).thenReturn(Optional.of(student));
        Mockito.when(studentMapper.studetResponseDto(student)).thenReturn(dto);

        //When
        StudetResponseDto responseDto = studentService.getsStudentById(id);

        //Then
        assertEquals(student.getLastName() , responseDto.LastName());
        assertEquals(student.getName() , responseDto.name());
        assertEquals(student.getEmail() , responseDto.email());

    }

    @Test
    public void testsGetsStudentByName(){
        //Given
        String firstName= "sujan";
        Student student1 = new Student(
                "sujan", "sujan@gmail.com", "dhakal", 20);
        List<Student> student = new ArrayList<>();
        student.add(student1);

        //Mock
        Mockito.when(repo.findStudentByNameContaining(firstName)).thenReturn(student);
        Mockito.when(studentMapper.studetResponseDto(any(Student.class))).thenReturn(
                new StudetResponseDto(
                        "sujan", "sujan@gmail.com", "dhakal"
                )
        );

        //When
        List<StudetResponseDto> responseDto = studentService.getsStudentsByName(firstName);

        //Then
        assertEquals(student.size(), responseDto.size());


    }


}