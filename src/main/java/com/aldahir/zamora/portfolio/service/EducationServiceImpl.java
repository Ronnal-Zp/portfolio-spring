package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.exception.ValidationException;
import com.aldahir.zamora.portfolio.model.Education;
import com.aldahir.zamora.portfolio.repository.IEducationRepository;
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
public class EducationServiceImpl implements IEducationService {

    private final IEducationRepository educationRepository;
    private final Validator validator;

    @Transactional(readOnly = true)
    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Education> findById(Long id) {
        return educationRepository.findById(id);
    }

    @Transactional()
    @Override
    public Education save(Education education) {
        BindingResult bindingResult = new BeanPropertyBindingResult(education, "education");
        validator.validate(education, bindingResult);
        if(bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }

        return educationRepository.save(education);
    }

    @Transactional()
    @Override
    public void deleteById(Long id) {
        educationRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Education> findEducationByPersonalInfoId(Long personalInfoId) {
        return educationRepository.findByPersonalInfoId(personalInfoId);
    }
}
