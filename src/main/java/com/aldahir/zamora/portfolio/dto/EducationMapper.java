package com.aldahir.zamora.portfolio.dto;

import com.aldahir.zamora.portfolio.model.Education;

public final class EducationMapper {

    public static EducationDto toDto(Education education) {
        if (education == null) {
            return null;
        }
        EducationDto dto = new EducationDto();
        dto.setId(education.getId());
        dto.setDegree(education.getDegree());
        dto.setInstitution(education.getInstitution());
        dto.setStartDate(education.getStartDate());
        dto.setEndDate(education.getEndDate());
        dto.setDescription(education.getDescription());
        dto.setPersonalInfoId(education.getPersonalInfoId());
        return dto;
    }

    public static Education toEntity(EducationDto dto) {
        if (dto == null) {
            return null;
        }
        Education education = new Education();
        education.setId(dto.getId());
        education.setDegree(dto.getDegree());
        education.setInstitution(dto.getInstitution());
        education.setStartDate(dto.getStartDate());
        education.setEndDate(dto.getEndDate());
        education.setDescription(dto.getDescription());
        education.setPersonalInfoId(dto.getPersonalInfoId());
        return education;
    }
}
