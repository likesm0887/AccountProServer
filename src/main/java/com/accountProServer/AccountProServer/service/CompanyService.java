package com.accountProServer.AccountProServer.service;

import com.accountProServer.AccountProServer.adapter.requestModel.company.AddDirectorRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.company.SetContactPersonRequestModel;
import com.accountProServer.AccountProServer.domain.company.ContactPerson;
import com.accountProServer.AccountProServer.domain.company.Director;
import com.accountProServer.AccountProServer.domain.project.Project;
import com.accountProServer.AccountProServer.infrastructure.repository.ProjectRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;


public class CompanyService {
    private ProjectRepository projectRepository;

    public CompanyService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void setContactPerson(SetContactPersonRequestModel setContactPersonRequestModel) {
        ContactPerson contactPerson = new ContactPerson(setContactPersonRequestModel.name,
                setContactPersonRequestModel.position,
                setContactPersonRequestModel.telephone,
                setContactPersonRequestModel.email);
        Project project = projectRepository
                .get(setContactPersonRequestModel.projectId);
        project.getCompany().setContactPerson(contactPerson);
        this.projectRepository.update(project);
    }

    public List<Director> getAllDirector(String projectId) {
        return this.projectRepository.get(projectId).getCompany().getDirectors();
    }

    public String addDirector(AddDirectorRequestModel addDirectorRequestModel) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Director director = null;
        UUID uuid = new UUID(System.currentTimeMillis(), System.currentTimeMillis());
        try {
            director = new Director(uuid.toString(), addDirectorRequestModel.directorNRIC,
                    addDirectorRequestModel.directorPassport,
                    addDirectorRequestModel.status,
                    addDirectorRequestModel.name,
                    format.parse(addDirectorRequestModel.resignedDate),
                    format.parse(addDirectorRequestModel.appointedDate));
        } catch (ParseException e) {
            throw new RuntimeException("error data format");
        }
        Project project = projectRepository
                .get(addDirectorRequestModel.projectId);
        project.getCompany().addDirectors(director);
        return uuid.toString();
    }
}
