package com.accountProServer.AccountProServer.service;

import com.accountProServer.AccountProServer.adapter.requestModel.secretaryFirm.AddSecretaryRequestModel;
import com.accountProServer.AccountProServer.domain.project.Project;
import com.accountProServer.AccountProServer.domain.secretaryFirm.Secretary;
import com.accountProServer.AccountProServer.domain.valueObject.NRIC;
import com.accountProServer.AccountProServer.infrastructure.repository.ProjectRepository;

import java.util.List;
import java.util.UUID;

public class SecretaryFirmService {
    private ProjectRepository projectRepository;

    public SecretaryFirmService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public String addSecretary(AddSecretaryRequestModel addSecretaryRequestModel) {
        UUID uuid = new UUID(System.currentTimeMillis(), System.currentTimeMillis());
        Project project = this.projectRepository.get(addSecretaryRequestModel.projectId);
        Secretary secretary = new Secretary(uuid.toString(), addSecretaryRequestModel.name,
                addSecretaryRequestModel.status,
                addSecretaryRequestModel.licenseNumber,
                new NRIC(addSecretaryRequestModel.secretaryNRIC));
        project.getSecretaryFirm().addSecretary(secretary);
        projectRepository.save(project);
        return uuid.toString();
    }

    public List<Secretary> getAllSecretary(String projectId) {
        return  this.projectRepository.get(projectId).getSecretaryFirm().getSecretaries();
    }
}
