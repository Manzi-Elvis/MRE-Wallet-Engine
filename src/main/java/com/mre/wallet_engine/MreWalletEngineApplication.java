package com.mre.walletengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MreWalletEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MreWalletEngineApplication.class, args);
    }
}