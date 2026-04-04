package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.exception.ValidationException;
import com.aldahir.zamora.portfolio.model.Education;
import com.aldahir.zamora.portfolio.repository.IEducationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EducationServiceImplTest {

    @Mock
    private IEducationRepository educationRepository;
    @Mock
    private Validator validator;
    @InjectMocks
    private EducationServiceImpl educationServiceImpl;

    @Test
    void testFindAllEducations() {
        List<Education> educationsExpected = Arrays.asList(
                new Education(1L, "Ingenieria de software", "ITB", LocalDate.now(), LocalDate.now(), "Programacion y redes", 1L),
                new Education(2L, "Administracion de empresas", "ITB", LocalDate.now(), LocalDate.now(), "Contabilidad", 2L)
        );
        when(educationRepository.findAll()).thenReturn(educationsExpected);

        List<Education> result = educationServiceImpl.findAll();

        assertNotNull(result, "No existen datos");
        assertEquals(result.size(), educationsExpected.size(), "No son los datos esperados");
        verify(educationRepository, times(1)).findAll();
    }

    @Test
    void testFindEducationById() {
        Long educationId = 1L;
        Optional<Education> educationOptional = Optional.of(new Education(1L,"Ingenieria de software", "ITB", LocalDate.now(), LocalDate.now(), "Programacion y redes", 1L));
        when(educationRepository.findById(educationId)).thenReturn(educationOptional);

        Optional<Education> result = educationServiceImpl.findById(educationId);

        assertNotNull(result, "No existen datos");
        assertTrue(result.isPresent(), "No existen datos");
        assertEquals(educationOptional.get().getId(), result.get().getId(), "No son los datos esperados");
        verify(educationRepository, times(1)).findById(educationId);
    }


    @Test
    void testSaveValidEducation() {
        Education validEducation =  new Education(1L, "Ingenieria de software", "ITB", LocalDate.now(), LocalDate.now(), "Programacion y redes", 1L);
        when(educationRepository.save(any(Education.class))).thenReturn(validEducation);

        Education educationSave = educationServiceImpl.save(validEducation);

        assertNotNull(educationSave, "No se guardo el registro");
        verify(educationRepository, times(1)).save(any(Education.class));
    }

    @Test
    void testSaveInvalidEducation() {
        Education invalidEducation = new Education();
        doAnswer(invocation -> {
            BindingResult bindingResult = invocation.getArgument(1);
            bindingResult.rejectValue("degree", "NotBlank", "degree invalid");
            return null;
        }).when(validator).validate(any(Education.class), any(BindingResult.class));

        assertThrows(ValidationException.class, () -> educationServiceImpl.save(invalidEducation), "Debe lanzar excepcion de educacion invalida");
        verify(educationRepository, never()).save(any(Education.class));
    }
}