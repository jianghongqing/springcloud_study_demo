package com.wangsong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class SpringcloudAppZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAppZipkinApplication.class, args);
    }
}