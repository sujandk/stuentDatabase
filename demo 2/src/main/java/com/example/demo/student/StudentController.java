package com.example.demo.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

  private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/posts-student")
    public StudetResponseDto postsStudent(
            @RequestBody  StudentDto dto
    ){

       return studentService.postsStudent(dto);
    }


    @GetMapping("/gets-student/{user_id}")
    public StudetResponseDto getsStudentById(
            @PathVariable("user_id") Integer id
    ){

        return studentService.getsStudentById(id);
    }

    @GetMapping("/gets-student")
    public List<StudetResponseDto> getsAllStudents(){

        return studentService.getsAllStudents();

    }

    @GetMapping("/gets-studentName/{name}")
    public List<StudetResponseDto> getsStudentsByName(
            @PathVariable("name") String firstName ){
        return studentService.getsStudentsByName(firstName);
    }



    @DeleteMapping("/deletes-student/{id}")
    public void deletesStudentById(
            @PathVariable  Integer id
    ){
         studentService.deletesStudentById(id);

    }


}
