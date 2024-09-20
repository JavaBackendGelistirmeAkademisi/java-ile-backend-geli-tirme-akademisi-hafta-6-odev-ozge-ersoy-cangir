package com.javabackendakademisi.freelancerMatchingPlatform.controller;

import com.javabackendakademisi.freelancerMatchingPlatform.entity.Project;
import com.javabackendakademisi.freelancerMatchingPlatform.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = projectService.saveProject(project);
        return ResponseEntity.ok(createdProject);
    }
}