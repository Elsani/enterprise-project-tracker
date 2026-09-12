package com.example.backend_demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Transactional
    public Project createProject(Project project) {
        // Këtu vendoset logjika e biznesit para ruajtjes
        if (project.getStatus() == null || project.getStatus().isBlank()) {
            project.setStatus("Planning");
        }
        return projectRepository.save(project);
    }

    @Transactional
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Projekti me ID " + id + " nuk u gjet!");
        }
        projectRepository.deleteById(id);
    }
}