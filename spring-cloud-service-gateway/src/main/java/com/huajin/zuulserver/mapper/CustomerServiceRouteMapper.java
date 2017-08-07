package com.huajin.zuulserver.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;

public class CustomerServiceRouteMapper implements ServiceRouteMapper {
	
	private static Logger log = LoggerFactory.getLogger(CustomerServiceRouteMapper.class);

	@Override
	public String apply(String serviceId) {
		log.info(">>>>>>>>>serviceId<<<<<<<<<" + serviceId);
		switch (serviceId) {
		case "materialserver":
			return "material";
		default:
			return "";
		}
	}

}
