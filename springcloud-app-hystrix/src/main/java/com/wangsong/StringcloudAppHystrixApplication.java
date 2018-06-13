package com.wangsong;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringCloudApplication
public class StringcloudAppHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(StringcloudAppHystrixApplication.class, args);
    }
}