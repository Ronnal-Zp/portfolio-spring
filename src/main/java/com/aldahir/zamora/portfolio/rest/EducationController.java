package com.aldahir.zamora.portfolio.rest;

import com.aldahir.zamora.portfolio.model.Education;
import com.aldahir.zamora.portfolio.service.IEducationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/education")
@AllArgsConstructor
public class EducationController {

    private final IEducationService educationService;

    @GetMapping("/all")
    public List<Education> getAllEducation(){
        return educationService.findAll();
    }

    @GetMapping("/{id}")
    public Education getEducationById(@PathVariable Long id){
        Optional<Education> info = educationService.findById(id);
        if (info.isPresent()) {
            return info.get();
        } else  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "education not found");
        }
    }

    @PostMapping()
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        Education newEducation = educationService.save(education);
        return new ResponseEntity<>(newEducation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Education> update(@PathVariable Long id, @RequestBody Education education) {
        education.setId(id);
        Education updatedEducation = educationService.save(education);
        return new ResponseEntity<>(updatedEducation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        educationService.deleteById(id);
    }

}
