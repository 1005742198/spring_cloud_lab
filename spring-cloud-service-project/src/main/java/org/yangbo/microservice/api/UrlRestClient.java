package org.yangbo.microservice.api;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yangbo.microservice.domain.ComplexRequest;
import org.yangbo.microservice.domain.User;

@FeignClient(name = "user-service", url = "http://localhost:9999", fallback=FallbackClient.class)
public interface UrlRestClient {
	@RequestMapping(value="/", method = RequestMethod.GET)
	String hello();
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	

	@RequestMapping(value="/user/name/{name}", method=RequestMethod.GET)
	public List<User> findByNameLike(@PathVariable("name") String name);
	
	@RequestMapping(value="/user/age/{age}", method=RequestMethod.GET)
	public List<User> findByAge(@PathVariable("age") Short age);
	 
	@RequestMapping(value="/user/complex", method=RequestMethod.POST, consumes="application/json")
	public User complex(ComplexRequest request);
}
