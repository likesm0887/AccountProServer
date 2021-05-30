package com.accountProServer.AccountProServer.service;

import com.accountProServer.AccountProServer.adapter.requestModel.user.LoginRequestModel;
import com.accountProServer.AccountProServer.adapter.requestModel.user.RegisterUserRequestModel;
import com.accountProServer.AccountProServer.domain.user.User;
import com.accountProServer.AccountProServer.domain.valueObject.NRIC;
import com.accountProServer.AccountProServer.infrastructure.repository.UserRepository;

import java.util.UUID;


public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(RegisterUserRequestModel registerUserRequestModel) {
        UUID uuid = new UUID(System.currentTimeMillis(), System.currentTimeMillis());
        User toRegisterUser = new User(uuid.toString(),
                registerUserRequestModel.account,
                registerUserRequestModel.password,
                new NRIC(registerUserRequestModel.NRIC),
                registerUserRequestModel.name,
                registerUserRequestModel.position,
                registerUserRequestModel.status,
                registerUserRequestModel.licenseNumber,
                registerUserRequestModel.licenseExpireDate);
        userRepository.save(toRegisterUser);
    }

    public User getUser(String id) {
        return userRepository.get(id);
    }

    public String login(LoginRequestModel loginRequestModel) {
        return userRepository.getAll().stream().filter(user -> user.getAccount().equals(loginRequestModel.account))
                .filter(user -> user.getPassword().equals(loginRequestModel.password))
                .findFirst().get().getId();
    }
}
