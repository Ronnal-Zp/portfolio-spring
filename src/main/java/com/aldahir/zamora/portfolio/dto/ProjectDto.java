package com.aldahir.zamora.portfolio.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectDto {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String projectUrl;
    private Long personalInfoId;
}
