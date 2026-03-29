package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.exception.ValidationException;
import com.aldahir.zamora.portfolio.model.Skill;
import com.aldahir.zamora.portfolio.repository.ISkillRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class SkillServiceTest {
    @Autowired
    private ISkillService skillService;
    @Autowired
    private ISkillRespository skillRespository;


    @Test
    void testSaveValidSkill() {
        Skill validSkill = new Skill(null, "Java", 90, "fa-java", 1L);
        Skill savedSkill = skillService.save(validSkill);

        assertNotNull(savedSkill.getId(), "El objeto guardado no tiene un id");

        assertNotNull(skillRespository
                .findById(savedSkill.getId())
                .orElse(null), "El objeto guardado no existe en la db"
        );
    }

    @Test
    void testSaveInvalidSkill() {
        Skill invalidSkill = new Skill(null, "", 90, "fa-java", 1L);

        assertThrows(ValidationException.class, () -> {
            skillService.save(invalidSkill);
        }, "El objeto guardado no es valido");
    }

}
