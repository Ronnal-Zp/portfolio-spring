package com.aldahir.zamora.portfolio.rest;

import com.aldahir.zamora.portfolio.model.Experience;
import com.aldahir.zamora.portfolio.dto.ExperienceDto;
import com.aldahir.zamora.portfolio.dto.ExperienceMapper;
import com.aldahir.zamora.portfolio.service.IExperienceService;
import jakarta.validation.Valid;
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
    public List<ExperienceDto> getAllExperience(){
        return experienceService.findAll().stream()
                .map(ExperienceMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ExperienceDto getExperienceById(@PathVariable Long id) {
        Optional<Experience> info = experienceService.findById(id);
        if (info.isPresent()) {
            return ExperienceMapper.toDto(info.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "experience not found");
        }
    }

    @PostMapping()
    public ResponseEntity<ExperienceDto> createExperience(@Valid @RequestBody ExperienceDto experienceDto) {
        Experience experience = ExperienceMapper.toEntity(experienceDto);
        Experience newExperience = experienceService.save(experience);
        return new ResponseEntity<>(ExperienceMapper.toDto(newExperience), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceDto> update(@PathVariable Long id, @Valid @RequestBody ExperienceDto experienceDto) {
        experienceDto.setId(id);
        Experience experience = ExperienceMapper.toEntity(experienceDto);
        Experience updatedExperience = experienceService.save(experience);
        return new ResponseEntity<>(ExperienceMapper.toDto(updatedExperience), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        experienceService.deleteById(id);
    }

}
