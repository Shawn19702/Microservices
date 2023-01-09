package com.student.api.student.api.controller;

import com.student.api.student.api.dto.ResponseDto;
import com.student.api.student.api.dto.StudentDto;
import com.student.api.student.api.model.Student;
import com.student.api.student.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentDto addStudent(@RequestBody StudentDto student){
      return studentService.createStudent(student);
    }

    @GetMapping
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseDto getStudentbyID(@PathVariable Long id){
return studentService.getStudentbyID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }



    @PutMapping("/students/{id}")
    public StudentDto updateStudent(@PathVariable Long id, @RequestBody StudentDto student){
        return studentService.updateStudent(id,student);
    }

}
