package com.accountProServer.AccountProServer.service;

import com.accountProServer.AccountProServer.adapter.requestModel.user.RegisterUserRequestModel;
import com.accountProServer.AccountProServer.domain.project.Project;
import com.accountProServer.AccountProServer.domain.user.User;
import com.accountProServer.AccountProServer.domain.valueObject.NRIC;


public class TestUtility {
    public static Project createProject() {
        return new Project("", "MyProject", "nothing");
    }
    public static Project createProject(String uuid) {
        return new Project(uuid, "MyProject", "nothing");
    }
    public static RegisterUserRequestModel createRegisterUserRequestModel(User user) {
        RegisterUserRequestModel registerUserRequestModel = new RegisterUserRequestModel();
        registerUserRequestModel.account = user.getAccount();
        registerUserRequestModel.password = user.getPassword();
        registerUserRequestModel.licenseExpireDate = user.getLicenseExpireDate();
        registerUserRequestModel.licenseNumber = user.getLicenseNumber();
        registerUserRequestModel.name = user.getName();
        registerUserRequestModel.NRIC = user.getNRIC().getValue();
        registerUserRequestModel.position = user.getPosition();
        registerUserRequestModel.status = user.getStatus();
        return registerUserRequestModel;
    }

    public static User createUser() {

        return new User("", "likesm0887", "james", new NRIC("L124928845"),"Yu-xin","0","0","","");
    }
}
