package com.accountProServer.AccountProServer.service;

import com.accountProServer.AccountProServer.adapter.requestModel.auditFirm.EstablishAuditFirmRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.project.AddUserRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.project.CreateProjectRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.project.EstablishCompanyRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.project.EstablishSecretaryFirmRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.user.GetUserAllProjectRequestModel;
import com.accountProServer.AccountProServer.domain.auditFirm.AuditFirm;
import com.accountProServer.AccountProServer.domain.company.Company;
import com.accountProServer.AccountProServer.domain.project.AuthorityEnums;
import com.accountProServer.AccountProServer.domain.project.AuthorityRecords;
import com.accountProServer.AccountProServer.domain.project.Project;
import com.accountProServer.AccountProServer.domain.report.Period;
import com.accountProServer.AccountProServer.domain.secretaryFirm.Secretary;
import com.accountProServer.AccountProServer.domain.secretaryFirm.SecretaryFirm;
import com.accountProServer.AccountProServer.domain.user.User;
import com.accountProServer.AccountProServer.infrastructure.repository.ProjectRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void addUser(AddUserRequestModel addUserRequestModel) {
        Project project = this.projectRepository.get(addUserRequestModel.projectId);
        AuthorityEnums authority = AuthorityEnums.Admin;
        if (addUserRequestModel.authorityEnums.equals("1"))
            authority = AuthorityEnums.Write;
        else if (addUserRequestModel.authorityEnums.equals("2"))
            authority = AuthorityEnums.Read;
        project.addUser(addUserRequestModel.userUuid, authority);
        projectRepository.update(project);
    }

    public void establishCompany(EstablishCompanyRequestModel establishCompanyRequestModel) {
        Project project = this.projectRepository.get(establishCompanyRequestModel.projectId);
        Company company = new Company(establishCompanyRequestModel.registerNumber,
                establishCompanyRequestModel.formerlyKnownAs,
                establishCompanyRequestModel.name,
                establishCompanyRequestModel.oldRegisterNo,
                establishCompanyRequestModel.originOfCompany,
                establishCompanyRequestModel.statusOfCompany,
                establishCompanyRequestModel.typeOfCompany,
                establishCompanyRequestModel.address);
        project.setCompany(company);
        projectRepository.update(project);
    }

    public void establishSecretaryFirm(EstablishSecretaryFirmRequestModel establishSecretaryFirmRequestModel) {
        Project project = this.projectRepository.get(establishSecretaryFirmRequestModel.projectId);
        SecretaryFirm secretaryFirm = new SecretaryFirm(establishSecretaryFirmRequestModel.firmRegisterNumber,
                establishSecretaryFirmRequestModel.name,
                establishSecretaryFirmRequestModel.email,
                establishSecretaryFirmRequestModel.telephone,
                establishSecretaryFirmRequestModel.address);
        project.setSecretaryFirm(secretaryFirm);
        projectRepository.update(project);
    }

    public void establishAuditFirm(EstablishAuditFirmRequestModel establishAuditFirmRequestModel) {
        Project project = this.projectRepository.get(establishAuditFirmRequestModel.projectId);
        project.setAuditFirm(new AuditFirm(establishAuditFirmRequestModel.auditFirmNumber,
                establishAuditFirmRequestModel.address,
                establishAuditFirmRequestModel.name));
        projectRepository.save(project);
    }

    public SecretaryFirm getSecretaryFirm(String projectId) {
        return this.getProjectById(projectId).getSecretaryFirm();
    }

    public Company getCompany(String projectId) {
        return this.getProjectById(projectId).getCompany();
    }

    public Project getProjectById(String projectId) {
        return projectRepository.get(projectId);
    }

    public void addSecretary(Project project, Secretary secretary) {
        project.getSecretaryFirm().addSecretary(secretary);
    }

    // 創建Project的User 預設為admin
    public String createProject(CreateProjectRequestModel createProjectRequestModel) {
        UUID uuid = new UUID(System.currentTimeMillis(), System.currentTimeMillis());
        Project project = new Project(uuid.toString(), createProjectRequestModel.projectName, createProjectRequestModel.description);
        project.userAuthorityRecords.add(new AuthorityRecords(createProjectRequestModel.userId, AuthorityEnums.Admin));
        projectRepository.save(project);
        return uuid.toString();
    }

    public List<Project> getTheUserAllProject(GetUserAllProjectRequestModel getUserAllProjectRequestModel) {
        return projectRepository.getAll().stream()
                .filter(project -> project.isUserInProject(getUserAllProjectRequestModel.userUuid))
                .collect(Collectors.toList());
    }

    public void changeUserProjectAuthority(User user, Project project, AuthorityEnums authorityEnum) {
        project.changeUserProjectAuthority(user, authorityEnum);
    }

    public void createReport(Period period) {

    }
}
