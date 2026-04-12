package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.model.PersonalInfo;
import com.aldahir.zamora.portfolio.repository.IPersonalInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonalInfoServiceImpl implements IPersonalInfoService {

    private final IPersonalInfoRepository personalInfoRepository;

    @Transactional
    @Override
    public PersonalInfo save(PersonalInfo personalInfo) {
        return personalInfoRepository.save(personalInfo);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PersonalInfo> findById(Long id) {
        return personalInfoRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PersonalInfo> findAll() {
        return personalInfoRepository.findAll();
    }

    @Transactional()
    @Override
    public void deleteById(Long id) {
        personalInfoRepository.deleteById(id);
    }
}
