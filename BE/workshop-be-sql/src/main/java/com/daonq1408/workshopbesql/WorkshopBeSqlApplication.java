package com.daonq1408.workshopbesql;

import com.daonq1408.workshopbesql.config.DotEnvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkshopBeSqlApplication {

    public static void main(String[] args) {
        DotEnvConfig.loadEnv();
        SpringApplication.run(WorkshopBeSqlApplication.class, args);
    }

}
