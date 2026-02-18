package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.model.Education;

import java.util.List;
import java.util.Optional;

public interface IEducationService {
    List<Education> findAll();
    Optional<Education> findById(Long id);
    Education save(Education education);
    void deleteById(Long id);
    List<Education> findEducationByPersonalInfoId(Long personalInfoId);
}
