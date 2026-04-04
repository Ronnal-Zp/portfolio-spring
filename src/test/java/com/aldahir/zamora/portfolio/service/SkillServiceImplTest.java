package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.exception.ValidationException;
import com.aldahir.zamora.portfolio.model.Skill;
import com.aldahir.zamora.portfolio.repository.ISkillRespository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SkillServiceImplTest {

    @Mock
    private ISkillRespository skillRespository;
    @Mock
    private Validator validator;
    @InjectMocks
    private SkillServiceImpl skillService;

    @Test
    void testFindAllSkills() {
        List<Skill> skillListExpected = Arrays.asList(
                new Skill(),
                new Skill()
        );
        when(skillRespository.findAll()).thenReturn(skillListExpected);

        List<Skill> result = skillService.findAll();

        assertNotNull(result, "Existen registros vacios");
        assertEquals(2, skillListExpected.size(), "Existen registros vacios");
        verify(skillRespository, times(1)).findAll();
    }

    @Test
    void testFindByIdSkill() {
        Skill skillExpected = new Skill(1L, "Java", 100, "fa-java", 1L);
        when(skillRespository.findById(1L)).thenReturn(Optional.of(skillExpected));

        Optional<Skill> skill = skillService.findById(1L);

        assertTrue(skill.isPresent(), "El objeto no existe");
        verify(skillRespository, times(1)).findById(1L);
    }

    @Test
    void testSaveSkillThrowsExceptionWhenInvalid() {
        Skill skillExpected = new Skill();
        doAnswer(invocationOnMock -> {
            BindingResult bindingResult = invocationOnMock.getArgument(1);
            bindingResult.rejectValue("name", "NotBlank", "El nombre es requerido");
            return null;
        }).when(validator).validate(any(Skill.class), any(BindingResult.class));

        assertThrows(
                ValidationException.class,
                () -> skillService.save(skillExpected),
                "Debe lanzar error de validacion"
        );
        verify(skillRespository, never()).save(any(Skill.class));
    }

    @Test
    void testSaveSkillValid() {
        Skill skillExpected = new Skill(null, "Java", 100, "fa-java", 1L);
        when(skillRespository.save(any(Skill.class))).thenReturn(skillExpected);
        doNothing().when(validator).validate(any(Skill.class), any(BindingResult.class));

        Skill skill = skillService.save(skillExpected);

        assertNotNull(skill, "El objeto no puede ser nulo.");
        assertEquals(skillExpected, skill, "No son iguales");
        verify(skillRespository, times(1)).save(any(Skill.class));
    }

}
