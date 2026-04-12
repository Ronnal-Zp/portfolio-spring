package com.aldahir.zamora.portfolio.rest;

import com.aldahir.zamora.portfolio.dto.SkillDto;
import com.aldahir.zamora.portfolio.dto.SkillMapper;
import com.aldahir.zamora.portfolio.model.Skill;
import com.aldahir.zamora.portfolio.service.ISkillService;
import jakarta.validation.Valid;
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
    public List<SkillDto> getAllSkill(){
        return skillService.findAll().stream()
                .map(SkillMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public SkillDto getSkillById(@PathVariable Long id){
        Optional<Skill> info = skillService.findById(id);
        if (info.isPresent()) {
            return SkillMapper.toDto(info.get());
        } else  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "skill not found");
        }
    }

    @PostMapping()
    public ResponseEntity<SkillDto> createSkill(@ModelAttribute @Valid SkillDto skillDto) {
        Skill skill = SkillMapper.toEntity(skillDto);
        Skill newSkill = skillService.save(skill);
        return new ResponseEntity<>(SkillMapper.toDto(newSkill), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillDto> update(@PathVariable Long id, @ModelAttribute @Valid SkillDto skillDto) {
        Skill skill = SkillMapper.toEntity(skillDto);
        skill.setId(id);
        Skill updatedSkill = skillService.save(skill);
        return new ResponseEntity<>(SkillMapper.toDto(updatedSkill), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        skillService.deleteById(id);
    }
    
}
