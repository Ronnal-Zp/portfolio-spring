package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.model.Education;
import com.aldahir.zamora.portfolio.repository.IEducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements IEducationService {

    private final IEducationRepository educationRepository;

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
