package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.model.Skill;
import com.aldahir.zamora.portfolio.repository.ISkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements ISkillService {

    private final ISkillRepository skillRepository;

    @Transactional
    @Override
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Skill> findById(Long id) {
        return skillRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Transactional()
    @Override
    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Skill> findByPesonalInfoId(Long personalInfoId) {
        return skillRepository.findByPesonalInfoId(personalInfoId);
    }
}
