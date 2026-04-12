package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.model.Project;
import com.aldahir.zamora.portfolio.repository.IProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService implements IProjectService {

    private final IProjectRepository projectRepository;

    @Override
    @Transactional
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        Path path = Paths.get("C:\\devProjects\\archivo-test.txt");
        List<String> lineas = null;
        try {
            lineas = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lineas.forEach(System.out::println);
        return projectRepository.findAll();
    }
}
