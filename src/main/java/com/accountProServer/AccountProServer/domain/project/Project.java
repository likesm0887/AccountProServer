package com.accountProServer.AccountProServer.domain.project;

import com.accountProServer.AccountProServer.domain.auditFirm.AuditFirm;
import com.accountProServer.AccountProServer.domain.company.Company;
import com.accountProServer.AccountProServer.domain.secretaryFirm.SecretaryFirm;
import com.accountProServer.AccountProServer.domain.user.User;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private final String projectName;
    private Company company;
    public List<AuthorityRecords> userAuthorityRecords = new ArrayList<>();
    private SecretaryFirm secretaryFirm;
    private AuditFirm auditFirm;
    private final String id;
    private final String description;


    public Project(String id, String projectName, String description) {
        this.id = id;
        this.description = description;
        this.projectName = projectName;
    }

    public boolean isUserInProject(String userId) {
        return this.userAuthorityRecords.stream()
                .anyMatch(authorityRecords -> authorityRecords.getUserId()
                        .equals(userId));
    }

    public void changeUserProjectAuthority(User user, AuthorityEnums authorityEnum) {
        userAuthorityRecords.stream()
                .filter(userAuthorityRecord -> userAuthorityRecord.getUserId().equals(user.getId()))
                .findFirst().ifPresent(userAuthorityRecord -> userAuthorityRecord.changeAuthority(authorityEnum));
    }

    public SecretaryFirm getSecretaryFirm() {
        return secretaryFirm;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void addUser(String userId, AuthorityEnums authorityEnum) {
        userAuthorityRecords.add(new AuthorityRecords(userId, authorityEnum));
    }

    public void setSecretaryFirm(SecretaryFirm secretaryFirm) {
        this.secretaryFirm = secretaryFirm;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public AuditFirm getAuditFirm() {
        return auditFirm;
    }

    public void setAuditFirm(AuditFirm auditFirm) {
        this.auditFirm = auditFirm;
    }
}
