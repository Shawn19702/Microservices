package school.app.school.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.app.school.dto.SchoolDto;
import school.app.school.model.School;
import school.app.school.repository.SchoolRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private ModelMapper modelMapper;


    public SchoolDto createSchool(SchoolDto schoolDto){
        // convert DTO to entity

        School school = modelMapper.map(schoolDto, School.class);

        School school1 = schoolRepository.save(school);

        // convert entity to DTO
        SchoolDto postResponse = modelMapper.map(school, SchoolDto.class);

        return postResponse;
    }

    public List<SchoolDto> getAllSchools(){
        List<School> schoolOptional = (List<School>) schoolRepository.findAll();
        return schoolOptional.stream().map(school -> modelMapper.map(school, SchoolDto.class))
                // stream holds each element in the list
                // map applies a function to each element in the stream
                //modelmapper.map takes in a object and matches its attributes to the class you want (School to SchoolDto)
                .collect(Collectors.toList());
        // collect the stream in a list

//        <String> names = List.of("Alice", "Bob", "Charlie");
//        List<String> uppercaseNames = names.stream()
//                .map(name -> name.toUpperCase())
//                .collect(Collectors.toList());
//
//        System.out.println(uppercaseNames);  // prints [ALICE, BOB, CHARLIE]
    }
    public SchoolDto getSchoolBySchoolCode (String schoolCode){
School school = schoolRepository.findSchoolByschoolCode(schoolCode);

        // finding id



// getting value of the optional finding by id


        SchoolDto postResponse = modelMapper.map(school, SchoolDto.class);
        // convert entity to DTO


        return postResponse;
    }

    public void deleteSchoolById(Long id) {
        schoolRepository.deleteById(id);
    }

    public SchoolDto updateSchool(Long id, SchoolDto SchoolDto){

        // convert DTO to entity

        School school = modelMapper.map(SchoolDto, School.class);

        School post = schoolRepository.save(school);

        // convert entity to DTO
        SchoolDto postResponse = modelMapper.map(school, SchoolDto.class);

        return postResponse;


    }
}

