package com.accountProServer.AccountProServer.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseHelper {
    private static final String serverName = "localhost:1433";
    private static final String userName = "sa";
    private static final String password = "james12345";

    public Connection getConnection() {
        String connectionUrl =
                "jdbc:sqlserver://" + serverName + "; databaseName=AccountPro";
        try {
            return DriverManager.getConnection(connectionUrl, userName, password);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
