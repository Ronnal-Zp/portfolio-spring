package com.aldahir.zamora.portfolio.repository;

import com.aldahir.zamora.portfolio.model.PersonalInfo;

import java.util.List;
import java.util.Optional;

public interface IPersonalInfoRespository {
    PersonalInfo save(PersonalInfo personalInfo);
    Optional<PersonalInfo> findById(Long id);
    List<PersonalInfo> findAll();
    void deleteById(Long id);
}
