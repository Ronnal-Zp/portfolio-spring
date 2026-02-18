package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.model.Education;
import com.aldahir.zamora.portfolio.repository.IEducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements IEducationService {

    private final IEducationRepository educationRepository;

    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    public Optional<Education> findById(Long id) {
        return educationRepository.findById(id);
    }

    @Override
    public Education save(Education education) {
        if (education.getStartDate() == null) {
            throw new IllegalArgumentException("La fecha de inicio de la educación no puede estar vacía.");
        }
        // La fecha de inicio no puede ser posterior a la de fin
        if(education.getEndDate() != null && education.getStartDate().isAfter(education.getEndDate())) {
            throw new IllegalArgumentException("La fecha de inicio de la educación no puede ser posterior a la fecha de fin.");
        }
        return educationRepository.save(education);
    }

    @Override
    public void deleteById(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public List<Education> findEducationByPersonalInfoId(Long personalInfoId) {
        return educationRepository.findByPersonalInfoId(personalInfoId);
    }
}
