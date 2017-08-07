package org.yangbo.microservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import feign.Feign.Builder;
import feign.hystrix.HystrixFeign;

public class MyFeignConfigure {
	
	@Bean
	@Scope("prototype")
    public Builder builder() {
        return HystrixFeign.builder();
    }

}

