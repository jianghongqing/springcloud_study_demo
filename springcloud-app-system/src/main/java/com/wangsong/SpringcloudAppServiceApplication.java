package com.wangsong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.wangsong.*.dao")
public class SpringcloudAppServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringcloudAppServiceApplication.class, args);

	}


}