package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.exception.ValidationException;
import com.aldahir.zamora.portfolio.model.Skill;
import com.aldahir.zamora.portfolio.repository.ISkillRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements ISkillService {

    private final ISkillRespository skillRespository;
    private final Validator validator;

    @Transactional
    @Override
    public Skill save(Skill skill) {
        BindingResult bindingResult = new BeanPropertyBindingResult(skill, "skill");
        validator.validate(skill, bindingResult);
        if(bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
        return skillRespository.save(skill);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Skill> findById(Long id) {
        return skillRespository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Skill> findAll() {
        return skillRespository.findAll();
    }

    @Transactional()
    @Override
    public void deleteById(Long id) {
        skillRespository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Skill> findByPesonalInfoId(Long personalInfoId) {
        return skillRespository.findByPesonalInfoId(personalInfoId);
    }
}
