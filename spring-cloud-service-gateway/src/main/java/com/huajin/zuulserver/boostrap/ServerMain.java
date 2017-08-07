package com.huajin.zuulserver.boostrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
@ComponentScan({"com.huajin.zuulserver.*"})
public class ServerMain {

	public static void main(String[] args) {
		SpringApplication.run(ServerMain.class, args);
	}

}
