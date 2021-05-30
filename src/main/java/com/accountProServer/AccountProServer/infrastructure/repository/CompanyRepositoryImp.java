package com.accountProServer.AccountProServer.infrastructure.repository;


import com.accountProServer.AccountProServer.domain.company.Company;
import com.accountProServer.AccountProServer.domain.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@Component
//public class CompanyRepositoryImp implements CompanyRepository {
//    private PreparedStatement insertInsertStatement;
//    private PreparedStatement selectStatement;
//    private Connection connection;
//
//    @Autowired
//    public CompanyRepositoryImp(Connection connection) {
//        this.connection = connection;
//        initializeStatement();
//    }
//
//    public void get(String registerNumber) {
//        try {
//            this.selectStatement.clearParameters();
//            this.selectStatement.setString(1, registerNumber);
//            ResultSet rs = this.selectStatement.executeQuery();
//            while (rs.next()) {
//                String empId = rs.getString(DBSchema.CompanyTable.Cols.ID);
//                String firstName = rs.getString("first_name");
//                String lastName = rs.getString("last_name");
//                String dept = rs.getString("dept");
//                System.out.println("Emp Id:- " + empId + " First Name:- " + firstName + " Last Name:- " + lastName +
//                        " Dept:- " + dept);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void save(Company company) {
//        try {
//            this.insertInsertStatement.clearParameters();
//            this.insertInsertStatement.setString(1, company.getRegisterNumber());
//            this.insertInsertStatement.setString(2, company.getSecretaryFirmRegisterNumberId());
//            this.insertInsertStatement.setString(3, company.getContactPersonId());
//            this.insertInsertStatement.setString(4, company.getFormerlyKnownAs());
//            this.insertInsertStatement.setString(5, company.getName());
//            this.insertInsertStatement.setString(6, company.getOldRegisterNo());
//            this.insertInsertStatement.setInt(7, company.getCompanyOriginEnum().getDataBaseValue());
//            this.insertInsertStatement.setInt(8, company.getCompanyStatusEnum().getDataBaseValue());
//            this.insertInsertStatement.setInt(9, company.getCompanyTypeEnum().getDataBaseValue());
//            this.insertInsertStatement.setString(10, company.getAddress());
//            this.insertInsertStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void initializeStatement() {
//        String insertCmd = "INSERT INTO " + DBSchema.CompanyTable.TABLE_NAME + "(" +
//                DBSchema.CompanyTable.Cols.REGISTER_NUMBER + ", " +
//                DBSchema.CompanyTable.Cols.SECRETARY_FIRM_ID_FK + ", " +
//                DBSchema.CompanyTable.Cols.CONTACT_PERSON_ID_FK + ", " +
//                DBSchema.CompanyTable.Cols.FORMERLY_KNOWN_AS + ", " +
//                DBSchema.CompanyTable.Cols.NAME + ", " +
//                DBSchema.CompanyTable.Cols.OLD_REGISTER_NO + ", " +
//                DBSchema.CompanyTable.Cols.ORIGIN_OF_COMPANY + ", " +
//                DBSchema.CompanyTable.Cols.STATUS_OF_COMPANY + ", " +
//                DBSchema.CompanyTable.Cols.TYPE_OF_COMPANY + ", " +
//                DBSchema.CompanyTable.Cols.ADDRESS + ") " + "VALUES(?,?,?,?,?,?,?,?,?,?)";
//
//
//        String selectCmd = "SELECT  * FROM " + DBSchema.CompanyTable.TABLE_NAME +
//                " WHERE " + DBSchema.CompanyTable.Cols.REGISTER_NUMBER + " = ? ";
//
//
//        try {
//            this.insertInsertStatement = connection.prepareStatement(insertCmd);
//            this.selectStatement = connection.prepareStatement(selectCmd);
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//    }
//}
