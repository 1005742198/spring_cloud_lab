package com.huajin.zuulserver.config;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.huajin.zuulserver.mapper.CustomerServiceRouteMapper;

@Configuration
public class ApplicationCongiguration {

	
//	@Bean
//	public PatternServiceRouteMapper serviceRouteMapper() {
//		String name = "${name}";
//		return new PatternServiceRouteMapper("(?<name>.*)-(?<version>v.*$)", "${version}/${name}");
//	}
	
//	@Bean
//	public CustomerServiceRouteMapper serviceRouteMapper() {
//		return new CustomerServiceRouteMapper();
//	}
}
