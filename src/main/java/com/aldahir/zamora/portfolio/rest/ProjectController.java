package com.aldahir.zamora.portfolio.rest;

import com.aldahir.zamora.portfolio.dto.ProjectDto;
import com.aldahir.zamora.portfolio.dto.ProjectMapper;
import com.aldahir.zamora.portfolio.model.Project;
import com.aldahir.zamora.portfolio.service.FileStorageService;
import com.aldahir.zamora.portfolio.service.IProjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/project")
@AllArgsConstructor
public class ProjectController {

    private final IProjectService projectService;
    private final FileStorageService fileStorageService;

    @GetMapping("/all")
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @PostMapping
    public Project save(
            @ModelAttribute @Valid ProjectDto projectDto,
            @RequestParam("file") MultipartFile file
    ) {
        try {
            String imageUrl = fileStorageService.storeFile(file);

            Project p = ProjectMapper.toEntity(projectDto);
            p.setImageUrl(imageUrl);
            return projectService.save(p);
        } catch (IOException e) {
            return null;
        }
    }

}
