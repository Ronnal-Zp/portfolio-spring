package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.exception.ValidationException;
import com.aldahir.zamora.portfolio.model.Experience;
import com.aldahir.zamora.portfolio.repository.IExperienceRepository;
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
public class ExperienceServiceImpl implements IExperienceService {

    private final IExperienceRepository experienceRepository;
    private final Validator validator;

    @Transactional(readOnly = true)
    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Experience> findById(Long id) {
        return experienceRepository.findById(id);
    }

    @Transactional()
    @Override
    public Experience save(Experience experience) {
        BindingResult bindingResult = new BeanPropertyBindingResult(experience, "experience");
        validator.validate(experience, bindingResult);
        if(bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
        return experienceRepository.save(experience);
    }

    @Transactional()
    @Override
    public void deleteById(Long id) {
        experienceRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Experience> findExperienceByPersonalInfoId(Long personalInfoId) {
        return experienceRepository.findByPersonalInfoId(personalInfoId);
    }
}
