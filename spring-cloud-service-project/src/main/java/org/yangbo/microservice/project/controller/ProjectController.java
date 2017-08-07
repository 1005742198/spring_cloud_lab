package org.yangbo.microservice.project.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.yangbo.microservice.api.UrlRestClient;
import org.yangbo.microservice.api.UserService;
import org.yangbo.microservice.domain.ComplexRequest;
import org.yangbo.microservice.domain.Global;
import org.yangbo.microservice.domain.Response;
import org.yangbo.microservice.domain.User;

import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/project")
public class ProjectController {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UrlRestClient urlClient;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@GetMapping("")
	public String index() {
		
		return "欢迎使用 Project 服务！";
	}
	
	@GetMapping("/gen")
	public String testGen() {
		Response<User> resp = userService.testGen();
		if (resp != null) {
			return resp.toString();
		}else{
			return "failed!";
		}
	}
	
	@GetMapping("/error")
	public String testError() {
		throw new MaxUploadSizeExceededException(1000);
	}
	
	@GetMapping("/complex")
	public User getUser() {
		log.debug("服务client准备请求服务...");
		User user = new User();
		user.setName("param name");
		user.setBalance(BigDecimal.TEN);
		Global global = new Global();
		ComplexRequest complexRequest = new ComplexRequest();
		complexRequest.setUser(user);
		complexRequest.setGlobal(global);
		User userResp = userService.complex(complexRequest);
		return userResp;
	}
	
	@GetMapping("/u/{id}")
	public User getUser(@PathVariable Long id){
		return urlClient.findById(id);
	}
	
	@GetMapping("/user/{id}")
	public User findUserById(@PathVariable Long id) {
		
		return userService.findById(id);
	}
	
	@GetMapping("/user/name/{name}")
	public List<User> findUserByName(@PathVariable String name) {
		
		return userService.findByNameLike(name);
	}
	
	@GetMapping("/clientinfo/{instanceId}")
	public List<?> clientInfo(@PathVariable String instanceId) {
		return eurekaClient.getInstancesById(instanceId);
	}
	
	@GetMapping("/getmap")
	public void testGetMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("p1", "v1");
		map.put("p2", "参数2");
		map.put("p3", 3);
		userService.findBy(7, map);
	}
}
