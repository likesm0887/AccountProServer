package com.accountProServer.AccountProServer.domain.project;

public class AuthorityRecords {
    private final String userId;
    private AuthorityEnums authorityEnum;

    public String getUserId() {
        return userId;
    }

    public AuthorityEnums getAuthorityEnum() {
        return authorityEnum;
    }

    public AuthorityRecords(String userId, AuthorityEnums authorityEnum) {
        this.userId = userId;
        this.authorityEnum = authorityEnum;
    }

    public void changeAuthority(AuthorityEnums authorityEnum) {
        this.authorityEnum = authorityEnum;
    }
}
