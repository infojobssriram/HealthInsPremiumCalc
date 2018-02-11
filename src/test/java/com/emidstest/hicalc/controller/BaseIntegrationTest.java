package com.emidstest.hicalc.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.emidstest.hicalc.App;

@SpringBootApplication
@EnableJpaRepositories
public class BaseIntegrationTest {


    public void contextLoads() throws Exception {
        SpringApplication.run(App.class).registerShutdownHook();
    }

}
