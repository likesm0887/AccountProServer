package com.accountProServer.AccountProServer;

import com.accountProServer.AccountProServer.infrastructure.DatabaseHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public Connection getDataSource() {
        return new DatabaseHelper().getConnection();
    }
}
