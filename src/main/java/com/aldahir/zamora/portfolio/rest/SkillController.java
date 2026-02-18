package com.aldahir.zamora.portfolio.rest;

import com.aldahir.zamora.portfolio.model.Skill;
import com.aldahir.zamora.portfolio.service.ISkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skill")
@AllArgsConstructor
public class SkillController {
    
    private ISkillService skillService;

    @GetMapping("/all")
    public List<Skill> getAllSkill(){
        return skillService.findAll();
    }

    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id){
        Optional<Skill> info = skillService.findById(id);
        if (info.isPresent()) {
            return info.get();
        } else  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "skill not found");
        }
    }

    @PostMapping()
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        Skill newSkill = skillService.save(skill);
        return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> update(@PathVariable Long id, @RequestBody Skill skill) {
        skill.setId(id);
        Skill updatedSkill = skillService.save(skill);
        return new ResponseEntity<>(updatedSkill, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        skillService.deleteById(id);
    }
    
}
