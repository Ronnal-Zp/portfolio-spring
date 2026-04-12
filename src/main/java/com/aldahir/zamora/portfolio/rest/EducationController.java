package com.aldahir.zamora.portfolio.rest;

import com.aldahir.zamora.portfolio.model.Education;
import com.aldahir.zamora.portfolio.dto.EducationDto;
import com.aldahir.zamora.portfolio.dto.EducationMapper;
import com.aldahir.zamora.portfolio.service.IEducationService;
import jakarta.validation.Valid;
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
    public List<EducationDto> getAllEducation(){
        return educationService.findAll().stream()
                .map(EducationMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public EducationDto getEducationById(@PathVariable Long id){
        Optional<Education> info = educationService.findById(id);
        if (info.isPresent()) {
            return EducationMapper.toDto(info.get());
        } else  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "education not found");
        }
    }

    @PostMapping()
    public ResponseEntity<EducationDto> createEducation(@Valid @RequestBody EducationDto educationDto) {
        Education education = EducationMapper.toEntity(educationDto);
        Education newEducation = educationService.save(education);
        return new ResponseEntity<>(EducationMapper.toDto(newEducation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationDto> update(@PathVariable Long id, @Valid @RequestBody EducationDto educationDto) {
        educationDto.setId(id);
        Education education = EducationMapper.toEntity(educationDto);
        Education updatedEducation = educationService.save(education);
        return new ResponseEntity<>(EducationMapper.toDto(updatedEducation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        educationService.deleteById(id);
    }

}
