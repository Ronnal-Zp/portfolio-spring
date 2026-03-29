package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.exception.ValidationException;
import com.aldahir.zamora.portfolio.model.PersonalInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PersonalInfoServiceTest {
    @Autowired
    IPersonalInfoService personalInfoService;

    @Test
    void testSaveValidPersonalInfo() {
        PersonalInfo personalInfo = new PersonalInfo(null, "Aldahir", "Zamora", "Tecnologo", "Desarrollador web", "", 3, "ronn.zp.3@gmail.com", "0994464375", "","");
        personalInfoService.save(personalInfo);

        assertNotNull(
                personalInfoService
                        .findById(personalInfo.getId())
                        .orElse(null),
      "El objeto existe en la base de datos"
        );
    }

    @Test
    void testSaveInvalidPersonalInfo() {
        PersonalInfo invalidPersonalInfo = new PersonalInfo();

        assertThrows(ValidationException.class, () -> {
            personalInfoService.save(invalidPersonalInfo);
        }, "El objeto es invalido");
    }
}
