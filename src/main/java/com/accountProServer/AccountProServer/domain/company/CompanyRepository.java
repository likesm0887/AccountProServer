package com.accountProServer.AccountProServer.domain.company;

public interface CompanyRepository {
    void save(Company company);

    void get(String registerNumber);
}
