package com.accountProServer.AccountProServer.service;


import com.accountProServer.AccountProServer.adapter.requestModel.project.CreateProjectRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.user.GetUserAllProjectRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.user.LoginRequestModel;
import com.accountProServer.AccountProServer.domain.user.User;
import com.accountProServer.AccountProServer.infrastructure.repository.ProjectRepository;
import com.accountProServer.AccountProServer.infrastructure.repository.UserRepository;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;

import static com.accountProServer.AccountProServer.service.TestUtility.createUser;

public class UserServiceTest extends TestCase {
    private UserService userService;
    private ProjectService projectService;

    @Before
    public void setUp() {
        UserRepository userRepository = new UserRepository();
        userService = new UserService(userRepository);
        projectService = new ProjectService(new ProjectRepository());
    }

    public void testRegister() {
        User toRegister = createUser();
        userService.register(TestUtility.createRegisterUserRequestModel(toRegister));
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.account = toRegister.getAccount();
        loginRequestModel.password = toRegister.getPassword();
        String userUuid = userService.login(loginRequestModel);
        assertEquals(userService.getUser(userUuid).getId(), userUuid);
    }

    public void testLogin() {
        User toRegister = createUser();
        userService.register(TestUtility.createRegisterUserRequestModel(toRegister));
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.account = "likesm0887";
        loginRequestModel.password = "james";
        Assert.assertEquals("Yu-xin", userService.getUser(userService.login(loginRequestModel)).getName());
    }

    public void testCreateProject() {
        User toRegister = createUser();
        userService.register(TestUtility.createRegisterUserRequestModel(toRegister));
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.account = "likesm0887";
        loginRequestModel.password = "james";
        String userUuid = userService.login(loginRequestModel);
        CreateProjectRequestModel createProjectRequestModel = new CreateProjectRequestModel();
        createProjectRequestModel.userId = userUuid;
        createProjectRequestModel.projectName = "MyProject";
        createProjectRequestModel.description = "nothing";
        String projectId = projectService.createProject(createProjectRequestModel);
        GetUserAllProjectRequestModel getUserAllProjectRequestModel = new GetUserAllProjectRequestModel();
        getUserAllProjectRequestModel.userUuid = userUuid;
        Assert.assertTrue(projectService.getTheUserAllProject(getUserAllProjectRequestModel).contains(projectService.getProjectById(projectId)));
    }
}