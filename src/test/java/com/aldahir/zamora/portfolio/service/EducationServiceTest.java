package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.exception.ValidationException;
import com.aldahir.zamora.portfolio.model.Education;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class EducationServiceTest {

    @Autowired
    private IEducationService educationService;

    @Test
    void testSaveValidEducation() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate haceCincoAnios = fechaActual.minusYears(5);

        Education education = new Education(null, "Tecnologo", "ITB", haceCincoAnios, haceCincoAnios, "Carrerar de tecnologia", 1L);
        Education savedEducation = educationService.save(education);

        assertNotNull(
                educationService
                        .findById(savedEducation.getId())
                        .orElse(null),
       "No se pudo guardar el education"
        );
    }

    @Test
    void testSaveInvalidEducation() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate haceCincoAnios = fechaActual.minusYears(5);

        Education education = new Education(null, "", "", haceCincoAnios, haceCincoAnios, "Carrerar de tecnologia", 1L);

        assertThrows(ValidationException.class, () -> {
            educationService.save(education);
        }, "No se pudo guardar el education");
    }


}
