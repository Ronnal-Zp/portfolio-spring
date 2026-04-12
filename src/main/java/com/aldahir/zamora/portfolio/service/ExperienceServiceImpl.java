package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.model.Experience;
import com.aldahir.zamora.portfolio.repository.IExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements IExperienceService {

    private final IExperienceRepository experienceRepository;

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
