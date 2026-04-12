package com.aldahir.zamora.portfolio.service;

import com.aldahir.zamora.portfolio.model.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectService {
    Project save(Project project);
    List<Project> findAll();
}
