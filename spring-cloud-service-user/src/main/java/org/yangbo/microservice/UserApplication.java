package org.yangbo.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.yangbo.microservice.user.entity.PropertyTest;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableAutoConfiguration
@ImportResource({"classpath:/spring-context.xml"})
@EnableCircuitBreaker
@EnableFeignClients({"com.huajin.listingserverclient.api", "com.huajin.timelineserverclient.api", "com.huajin.commander.client"})
@ComponentScan({"com.huajin.bigserver.*", "com.huajin.tradeserver.*"})
public class UserApplication implements CommandLineRunner{

	@Autowired
	private PropertyTest prop;
	
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== name > " + prop.getName());
	}
}
