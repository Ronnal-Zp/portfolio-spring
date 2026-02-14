package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.model.PersonalInfo;
import com.aldahir.zamora.portfolio.repository.IPersonalInfoRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonalInfoServiceImpl implements IPersonalInfoService {

    private final IPersonalInfoRespository personalInfoRespository;

    @Override
    public PersonalInfo save(PersonalInfo personalInfo) {
        return personalInfoRespository.save(personalInfo);
    }

    @Override
    public Optional<PersonalInfo> findById(Long id) {
        return personalInfoRespository.findById(id);
    }

    @Override
    public List<PersonalInfo> findAll() {
        return personalInfoRespository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        personalInfoRespository.deleteById(id);
    }
}
