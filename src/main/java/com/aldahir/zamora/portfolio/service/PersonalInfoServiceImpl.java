package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.exception.ValidationException;
import com.aldahir.zamora.portfolio.model.PersonalInfo;
import com.aldahir.zamora.portfolio.repository.IPersonalInfoRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonalInfoServiceImpl implements IPersonalInfoService {

    private final IPersonalInfoRespository personalInfoRespository;
    private final Validator validator;

    @Transactional
    @Override
    public PersonalInfo save(PersonalInfo personalInfo) {
        BindingResult bindingResult = new BeanPropertyBindingResult(personalInfo, "personalInfo");
        validator.validate(personalInfo, bindingResult);
        if(bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }

        return personalInfoRespository.save(personalInfo);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PersonalInfo> findById(Long id) {
        return personalInfoRespository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PersonalInfo> findAll() {
        return personalInfoRespository.findAll();
    }

    @Transactional()
    @Override
    public void deleteById(Long id) {
        personalInfoRespository.deleteById(id);
    }
}
