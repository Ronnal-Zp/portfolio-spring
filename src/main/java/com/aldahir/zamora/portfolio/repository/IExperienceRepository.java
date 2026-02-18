package com.aldahir.zamora.portfolio.repository;

import com.aldahir.zamora.portfolio.model.Experience;

import java.util.List;
import java.util.Optional;

public interface IExperienceRepository {
    List<Experience> findAll();
    Optional<Experience> findById(Long id);
    Experience save(Experience experience);
    void deleteById(Long id);
    List<Experience> findByPersonalInfoId(Long personalInfoId);
}
