package com.aldahir.zamora.portfolio.repository;

import com.aldahir.zamora.portfolio.model.Skill;

import java.util.List;
import java.util.Optional;

public interface ISkillRepository {
    Skill save(Skill skill);
    Optional<Skill> findById(Long id);
    List<Skill> findAll();
    void deleteById(Long id);
    List<Skill> findByPesonalInfoId(Long personalInfoId);
}
