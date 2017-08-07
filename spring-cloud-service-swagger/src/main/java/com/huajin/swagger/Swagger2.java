package com.huajin.swagger;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages = { "com.huajin.swagger.*" })
@EnableSwagger2
public class Swagger2 {

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.huajin.swagger"))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.directModelSubstitute(LocalDate.class, String.class)
				.genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false)
				.enableUrlTemplating(true);
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring cloud 中使用Swagger2构建Restful APIs")
				.description(".......")
				.termsOfServiceUrl("git@github.com:LiuwqGit/spring-boot-eureka.git")
				.contact("huajin").version("1.0").build();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
