package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.model.Skill;
import com.aldahir.zamora.portfolio.repository.ISkillRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements ISkillService {

    private final ISkillRespository skillRespository;

    @Override
    public Skill save(Skill skill) {
        if(skill.getLevelPercentage() < 0 ||  skill.getLevelPercentage() > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 e 100");
        }
        return skillRespository.save(skill);
    }

    @Override
    public Optional<Skill> findById(Long id) {
        return skillRespository.findById(id);
    }

    @Override
    public List<Skill> findAll() {
        return skillRespository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        skillRespository.deleteById(id);
    }

    @Override
    public List<Skill> findByPesonalInfoId(Long personalInfoId) {
        return skillRespository.findByPesonalInfoId(personalInfoId);
    }
}
