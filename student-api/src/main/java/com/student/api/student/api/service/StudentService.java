package com.student.api.student.api.service;

import com.student.api.student.api.dto.ResponseDto;
import com.student.api.student.api.dto.SchoolDto;
import com.student.api.student.api.dto.StudentDto;
import com.student.api.student.api.model.Student;
import com.student.api.student.api.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    //Fake db



@Autowired
private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private RestTemplate restTemplate;



    public StudentDto createStudent(StudentDto studentDto){
    // convert DTO to entity

    Student student = modelMapper.map(studentDto, Student.class);

    Student post = studentRepository.save(student);

    // convert entity to DTO
    StudentDto postResponse = modelMapper.map(student, StudentDto.class);

return postResponse;
}

    public List<StudentDto> getAllStudents(){
        List<Student> studentOptional = (List<Student>) studentRepository.findAll();
        return studentOptional.stream().map(student -> modelMapper.map(student, StudentDto.class))
                // stream holds each element in the list
                // map applies a function to each element in the stream
                //modelmapper.map takes in a object and matches its attributes to the class you want (student to studentDto)
                .collect(Collectors.toList());
        // collect the stream in a list

//        <String> names = List.of("Alice", "Bob", "Charlie");
//        List<String> uppercaseNames = names.stream()
//                .map(name -> name.toUpperCase())
//                .collect(Collectors.toList());
//
//        System.out.println(uppercaseNames);  // prints [ALICE, BOB, CHARLIE]
    }
    public ResponseDto getStudentbyID (Long id){

        Student student = studentRepository.findById(id).get();

        // getting value of finding by id

        ResponseEntity<SchoolDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/school/" + student.getSchoolCode(), SchoolDto.class );
// restTemplate.getForEntity() is a method in the RestTemplate class that is used to make a GET request to the specified URI
// were making a get request to the getSchoolBySchoolCode method
// we use Student Dto.class because we want to get the body of the studentDto object


        SchoolDto schoolResponse = responseEntity.getBody();

        // getting body of the response entity object and method

        StudentDto studentResponse = modelMapper.map(student, StudentDto.class);
  // converting student object that finds by id to StudentDto

        ResponseDto responseDto = new ResponseDto();

        responseDto.setSchool(schoolResponse);
        responseDto.setStudent(studentResponse);
        // setting the response dto object to school and student response

        return responseDto;
    }

    public void deleteStudentById(Long id) {
         studentRepository.deleteById(id);
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto){

        // convert DTO to entity

        Student student1 = modelMapper.map(studentDto, Student.class);

        Student post = studentRepository.save(student1);

        // convert entity to DTO
        StudentDto postResponse = modelMapper.map(student1, StudentDto.class);

        return postResponse;


    }
}




