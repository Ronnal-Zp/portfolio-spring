package com.aldahir.zamora.portfolio.rest;

import com.aldahir.zamora.portfolio.model.PersonalInfo;
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
    public List<PersonalInfo> getAllPersonalInfo(){
        return personalInfoService.findAll();
    }

    @GetMapping("/{id}")
    public PersonalInfo getPersonalInfoById(@PathVariable Long id){
        Optional<PersonalInfo> info = personalInfoService.findById(id);
        if (info.isPresent()) {
            return info.get();
        } else  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "personal-info not found");
        }
    }

    @PostMapping()
    public ResponseEntity<PersonalInfo> createPersonalInfo(@RequestBody PersonalInfo personalInfo) {
        PersonalInfo newPersonalInfo = personalInfoService.save(personalInfo);
        return new ResponseEntity<>(newPersonalInfo, HttpStatus.CREATED);
    }

}
