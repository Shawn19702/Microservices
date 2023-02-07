package school.app.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.app.school.dto.SchoolDto;
import school.app.school.service.SchoolService;

import java.util.List;
@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService SchoolService;

    /// shawn branch testing

    @PostMapping
    public SchoolDto addSchool(@RequestBody SchoolDto school){
        return SchoolService.createSchool(school);
    }

    @GetMapping
    public List<SchoolDto> getAllSchools(){
        return SchoolService.getAllSchools();
    }

    @GetMapping("/{schoolCode}")
    public SchoolDto getSchoolBySchoolCode(@PathVariable String schoolCode){
        return SchoolService.getSchoolBySchoolCode(schoolCode);
    }

    @DeleteMapping("/{id}")
    public void deleteSchoolById(@PathVariable Long id){
        SchoolService.deleteSchoolById(id);
    }

    @PutMapping("/{id}")
    public SchoolDto updateSchool(@PathVariable Long id, @RequestBody SchoolDto schoolDto){
        return SchoolService.updateSchool(id,schoolDto);
    }
}
