package com.aldahir.zamora.portfolio.dto;

import com.aldahir.zamora.portfolio.model.Experience;

public final class ExperienceMapper {

    public static ExperienceDto toDto(Experience experience) {
        if (experience == null) {
            return null;
        }
        ExperienceDto dto = new ExperienceDto();
        dto.setId(experience.getId());
        dto.setJobTitle(experience.getJobTitle());
        dto.setCompanyName(experience.getCompanyName());
        dto.setStartDate(experience.getStartDate());
        dto.setEndDate(experience.getEndDate());
        dto.setDescription(experience.getDescription());
        dto.setPersonalInfoId(experience.getPersonalInfoId());
        return dto;
    }

    public static Experience toEntity(ExperienceDto dto) {
        if (dto == null) {
            return null;
        }
        Experience experience = new Experience();
        experience.setId(dto.getId());
        experience.setJobTitle(dto.getJobTitle());
        experience.setCompanyName(dto.getCompanyName());
        experience.setStartDate(dto.getStartDate());
        experience.setEndDate(dto.getEndDate());
        experience.setDescription(dto.getDescription());
        experience.setPersonalInfoId(dto.getPersonalInfoId());
        return experience;
    }
}
