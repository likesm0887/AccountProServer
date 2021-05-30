package com.accountProServer.AccountProServer.service;

import com.accountProServer.AccountProServer.adapter.requestModel.company.AddDirectorRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.company.SetContactPersonRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.project.EstablishCompanyRequestModel;
import com.accountProServer.AccountProServer.domain.project.Project;
import com.accountProServer.AccountProServer.infrastructure.repository.ProjectRepository;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.UUID;

public class CompanyServiceTest extends TestCase {

    public void testSetContactPerson() {
        ProjectRepository projectRepository = new ProjectRepository();
        Project project = TestUtility.createProject(new UUID(System.currentTimeMillis(), System.currentTimeMillis()).toString());
        projectRepository.save(project);
        CompanyService companyService = new CompanyService(projectRepository);
        ProjectService projectService = new ProjectService(projectRepository);

        EstablishCompanyRequestModel establishCompanyRequestModel = new EstablishCompanyRequestModel();
        establishCompanyRequestModel.typeOfCompany = "company";
        establishCompanyRequestModel.originOfCompany = "";
        establishCompanyRequestModel.statusOfCompany = "";
        establishCompanyRequestModel.address = "";
        establishCompanyRequestModel.formerlyKnownAs = "";
        establishCompanyRequestModel.name = "";
        establishCompanyRequestModel.registerNumber = "";
        establishCompanyRequestModel.oldRegisterNo = "";
        establishCompanyRequestModel.projectId = project.getId();
        projectService.establishCompany(establishCompanyRequestModel);

        SetContactPersonRequestModel setContactPersonRequestModel = new SetContactPersonRequestModel();
        setContactPersonRequestModel.position = "1";
        setContactPersonRequestModel.name = "jammy";
        setContactPersonRequestModel.email = "likesm0887@yahoo.com.tw";
        setContactPersonRequestModel.telephone = "0977565089";
        setContactPersonRequestModel.projectId = project.getId();

        companyService.setContactPerson(setContactPersonRequestModel);

        Assert.assertEquals(projectService.getCompany(project.getId()).getContactPerson().getName(), "jammy");
    }

    public void testAddDirector() {
        ProjectRepository projectRepository = new ProjectRepository();
        Project project = TestUtility.createProject(new UUID(System.currentTimeMillis(), System.currentTimeMillis()).toString());
        projectRepository.save(project);
        CompanyService companyService = new CompanyService(projectRepository);
        ProjectService projectService = new ProjectService(projectRepository);

        EstablishCompanyRequestModel establishCompanyRequestModel = new EstablishCompanyRequestModel();
        establishCompanyRequestModel.typeOfCompany = "company";
        establishCompanyRequestModel.originOfCompany = "";
        establishCompanyRequestModel.statusOfCompany = "";
        establishCompanyRequestModel.address = "";
        establishCompanyRequestModel.formerlyKnownAs = "";
        establishCompanyRequestModel.name = "";
        establishCompanyRequestModel.registerNumber = "";
        establishCompanyRequestModel.oldRegisterNo = "";
        establishCompanyRequestModel.projectId = project.getId();
        projectService.establishCompany(establishCompanyRequestModel);
        AddDirectorRequestModel addDirectorRequestModel = new AddDirectorRequestModel();
        addDirectorRequestModel.projectId = project.getId();
        addDirectorRequestModel.name = "jammy";
        addDirectorRequestModel.appointedDate="04/05/2021";
        addDirectorRequestModel.resignedDate="04/05/2021";
        String directorId = companyService.addDirector(addDirectorRequestModel);
        String assertName = companyService.getAllDirector(project.getId()).stream().filter(director -> director.getId().equals(directorId)).findFirst().get().getName();
        Assert.assertEquals(assertName,"jammy");
    }
}