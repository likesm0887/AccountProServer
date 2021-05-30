package com.accountProServer.AccountProServer.service;


import com.accountProServer.AccountProServer.adapter.requestModel.project.AddUserRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.project.CreateProjectRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.project.EstablishCompanyRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.project.EstablishSecretaryFirmRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.user.GetUserAllProjectRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.user.LoginRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.user.RegisterUserRequestModel;
import com.accountProServer.AccountProServer.domain.company.Company;
import com.accountProServer.AccountProServer.domain.project.AuthorityEnums;
import com.accountProServer.AccountProServer.domain.project.Project;
import com.accountProServer.AccountProServer.domain.user.User;
import com.accountProServer.AccountProServer.infrastructure.repository.ProjectRepository;
import com.accountProServer.AccountProServer.infrastructure.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.accountProServer.AccountProServer.service.TestUtility.*;
import static junit.framework.Assert.assertEquals;


public class ProjectServiceTest {
    private ProjectService projectService;
    private UserService userService;
    private SecretaryFirmService secretaryFirmService;

    @Before
    public void setUp() {
        ProjectRepository projectRepository = new ProjectRepository();
        secretaryFirmService = new SecretaryFirmService(projectRepository);
        projectService = new ProjectService(projectRepository);
        UserRepository userRepository = new UserRepository();
        userService = new UserService(userRepository);
    }

    @Test
    public void testAddUser() {
        AddUserRequestModel addUserRequestModel = new AddUserRequestModel();
        User toRegister = createUser();

        String projectId = projectService.createProject(createProjectRequestModel(toRegister, createProject()));
        Project project = projectService.getProjectById(projectId);
        User secondUser = createUser();
        addUserRequestModel.userUuid = secondUser.getId();
        addUserRequestModel.authorityEnums = "1";
        addUserRequestModel.projectId = projectId;

        projectService.addUser(addUserRequestModel);

        assertEquals(project.userAuthorityRecords.get(1).getAuthorityEnum(), AuthorityEnums.Write);
    }

    /**
     * register->login->createProject
     */
    @Test
    public void testCreateProject() {
        User toRegister = createUser();
        RegisterUserRequestModel registerUserRequestModel = new RegisterUserRequestModel();
        registerUserRequestModel.account = toRegister.getAccount();
        registerUserRequestModel.password = toRegister.getPassword();
        registerUserRequestModel.licenseExpireDate = toRegister.getLicenseExpireDate();
        registerUserRequestModel.licenseNumber = toRegister.getLicenseNumber();
        registerUserRequestModel.name = toRegister.getName();
        registerUserRequestModel.NRIC = toRegister.getNRIC().getValue();
        registerUserRequestModel.position = toRegister.getPosition();
        registerUserRequestModel.status = toRegister.getStatus();

        userService.register(registerUserRequestModel);
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.account = toRegister.getAccount();
        loginRequestModel.password = toRegister.getPassword();
        String userId = userService.login(loginRequestModel);

        Project project = createProject();
        String projectId = projectService.createProject(createProjectRequestModel(userService.getUser(userId), project));
        project = projectService.getProjectById(projectId);
        assertEquals(project.userAuthorityRecords.get(0).getUserId(), userService.getUser(userId).getId());
    }


    @Test
    public void testEstablishCompany() {
        User user = createUser();
        Project project = createProject();
        RegisterUserRequestModel registerUserRequestModel = createRegisterUserRequestModel(user);
        userService.register(registerUserRequestModel);
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.account = user.getAccount();
        loginRequestModel.password = user.getPassword();
        String projectId = projectService.createProject(createProjectRequestModel(user, project));
        Company company = new Company("registerNumber",
                "formerlyKnownAs",
                "name",
                "oldRegisterNo",
                "originOfCompany",
                "statusOfCompany",
                "typeOfCompany",
                "address");
        EstablishCompanyRequestModel establishCompanyRequestModel = new EstablishCompanyRequestModel();
        establishCompanyRequestModel.typeOfCompany = company.getTypeOfCompany();
        establishCompanyRequestModel.originOfCompany = company.getOriginOfCompany();
        establishCompanyRequestModel.statusOfCompany = company.getStatusOfCompany();
        establishCompanyRequestModel.address = company.getAddress();
        establishCompanyRequestModel.formerlyKnownAs = company.getFormerlyKnownAs();
        establishCompanyRequestModel.name = company.getName();
        establishCompanyRequestModel.registerNumber = company.getRegisterNumber();
        establishCompanyRequestModel.oldRegisterNo = company.getOldRegisterNo();
        establishCompanyRequestModel.projectId = projectId;
        projectService.establishCompany(establishCompanyRequestModel);
        Assert.assertEquals(projectService.getCompany(projectId).getName(), "name");
    }

    @Test
    public void testEstablishSecretaryFirm() {
        User toRegister = createUser();
        Project project = createProject();
        String projectId = projectService.createProject(createProjectRequestModel(toRegister, project));
        EstablishSecretaryFirmRequestModel establishSecretaryFirmRequestModel= new EstablishSecretaryFirmRequestModel();
        establishSecretaryFirmRequestModel.address="123-1453";
        establishSecretaryFirmRequestModel.projectId=projectId;
        establishSecretaryFirmRequestModel.name="james";
        establishSecretaryFirmRequestModel.firmRegisterNumber="12355";
        establishSecretaryFirmRequestModel.telephone = "0909777556";
        projectService.establishSecretaryFirm(establishSecretaryFirmRequestModel);
        assertEquals("james",projectService.getProjectById(projectId).getSecretaryFirm().getName());
    }

    @Test
    public void changeUserProjectAuthority() {
        User toRegister = createUser();
        Project project = createProject();
        String projectId = projectService.createProject(createProjectRequestModel(toRegister, project));
        project = projectService.getProjectById(projectId);
        projectService.changeUserProjectAuthority(toRegister, project, AuthorityEnums.Read);
        GetUserAllProjectRequestModel getUserAllProjectRequestModel = new GetUserAllProjectRequestModel();
        getUserAllProjectRequestModel.userUuid = toRegister.getId();
        assertEquals(projectService.getTheUserAllProject(getUserAllProjectRequestModel).get(0).userAuthorityRecords.get(0).getAuthorityEnum(), AuthorityEnums.Read);
    }

    private CreateProjectRequestModel createProjectRequestModel(User user, Project project) {
        CreateProjectRequestModel createProjectRequestModel = new CreateProjectRequestModel();
        createProjectRequestModel.userId = user.getId();
        createProjectRequestModel.projectName = project.getProjectName();
        createProjectRequestModel.description = project.getDescription();
        return createProjectRequestModel;
    }
}