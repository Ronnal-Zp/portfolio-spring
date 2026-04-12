package com.aldahir.zamora.portfolio.rest;

import com.aldahir.zamora.portfolio.model.PersonalInfo;
import com.aldahir.zamora.portfolio.dto.PersonalInfoDto;
import com.aldahir.zamora.portfolio.dto.PersonalInfoMapper;
import jakarta.validation.Valid;
import com.aldahir.zamora.portfolio.service.IPersonalInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personal-info")
@AllArgsConstructor
public class PersonalInfoController {

    private IPersonalInfoService personalInfoService;

    @GetMapping("/all")
    public List<PersonalInfoDto> getAllPersonalInfo(){
        return personalInfoService.findAll().stream()
                .map(PersonalInfoMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public PersonalInfoDto getPersonalInfoById(@PathVariable Long id){
        Optional<PersonalInfo> info = personalInfoService.findById(id);
        if (info.isPresent()) {
            return PersonalInfoMapper.toDto(info.get());
        } else  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "personal-info not found");
        }
    }

    @PostMapping()
    public ResponseEntity<PersonalInfoDto> createPersonalInfo(@Valid @RequestBody PersonalInfoDto personalInfoDto) {
        PersonalInfo personalInfo = PersonalInfoMapper.toEntity(personalInfoDto);
        PersonalInfo newPersonalInfo = personalInfoService.save(personalInfo);
        return new ResponseEntity<>(PersonalInfoMapper.toDto(newPersonalInfo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalInfoDto> update(@PathVariable Long id, @Valid @RequestBody PersonalInfoDto personalInfoDto) {
        personalInfoDto.setId(id);
        PersonalInfo personalInfo = PersonalInfoMapper.toEntity(personalInfoDto);
        PersonalInfo updatedPersonalInfo = personalInfoService.save(personalInfo);
        return new ResponseEntity<>(PersonalInfoMapper.toDto(updatedPersonalInfo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personalInfoService.deleteById(id);
    }

}
