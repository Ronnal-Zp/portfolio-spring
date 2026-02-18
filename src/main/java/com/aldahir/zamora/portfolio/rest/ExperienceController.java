package com.aldahir.zamora.portfolio.rest;

import com.aldahir.zamora.portfolio.model.Experience;
import com.aldahir.zamora.portfolio.service.IExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/experience")
@AllArgsConstructor
public class ExperienceController {

    private IExperienceService experienceService;

    @GetMapping("/all")
    public List<Experience> getAllExperience(){
        return experienceService.findAll();
    }

    @GetMapping("/{id}")
    public Experience getExperienceById(@PathVariable Long id) {
        Optional<Experience> info = experienceService.findById(id);
        if (info.isPresent()) {
            return info.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "experience not found");
        }
    }

    @PostMapping()
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {
        Experience newExperience = experienceService.save(experience);
        return new ResponseEntity<>(newExperience, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> update(@PathVariable Long id, @RequestBody Experience experience) {
        experience.setId(id);
        Experience updatedExperience = experienceService.save(experience);
        return new ResponseEntity<>(updatedExperience, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        experienceService.deleteById(id);
    }

}
