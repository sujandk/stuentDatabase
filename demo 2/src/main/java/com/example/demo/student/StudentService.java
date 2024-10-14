package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repo;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repo, StudentMapper studentMapper) {
        this.repo = repo;
        this.studentMapper = studentMapper;
    }

    public StudetResponseDto postsStudent(
             StudentDto dto
    ){
        var student= studentMapper.toStudent(dto);
        var studentReturnDto = repo.save(student);
        return studentMapper.studetResponseDto(studentReturnDto);
    }

    public StudetResponseDto getsStudentById(
             Integer id
    ){
        var studentReturnDto= repo.findById(id)
                .orElse(new Student());
        return studentMapper.studetResponseDto(studentReturnDto);
    }

    public List<StudetResponseDto> getsAllStudents(){
        var allStudentsReturn = repo.findAll();
        return allStudentsReturn.stream().map(studentMapper :: studetResponseDto).collect(Collectors.toList());

    }

    public List<StudetResponseDto> getsStudentsByName(
            String firstName ){
        var allStudentsReturn =  repo.findStudentByNameContaining(firstName);
        return allStudentsReturn.stream().map(studentMapper :: studetResponseDto).collect(Collectors.toList());

    }

    public void deletesStudentById(
             Integer id
    ){
        repo.deleteById(id);

    }
}
