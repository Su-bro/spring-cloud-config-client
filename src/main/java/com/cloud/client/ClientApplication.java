package com.cloud.client;

import com.cloud.client.properties.DatabaseProperties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Autowired
    public DatabaseProperties databaseProperties;

    @GetMapping("/get")
    public void getmaster() {
        System.out.println("-- URL: "+databaseProperties.getMaster().getDatasource().getUrl());
        System.out.println("-- UserName: "+databaseProperties.getMaster().getDatasource().getUsername());
        System.out.println("-- Password: "+databaseProperties.getMaster().getDatasource().getPassword());
    }

}
