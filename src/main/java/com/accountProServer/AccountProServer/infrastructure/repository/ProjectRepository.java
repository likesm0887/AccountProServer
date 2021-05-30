package com.accountProServer.AccountProServer.infrastructure.repository;

import com.accountProServer.AccountProServer.domain.project.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {
    List<Project> projects = new ArrayList<>();

    public List<Project> getAll() {
        return projects;
    }

    public void save(Project project) {
        projects.add(project);
    }

    public Project get(String id) {
        return this.projects.stream().filter(project -> project.getId().equals(id)).findFirst().get();
    }

    public void update(Project project) {
        projects.stream()
                .filter(project1 -> project1.getId().equals(project.getId()))
                .findFirst().ifPresent(project1 -> project1 = project);
    }
}
