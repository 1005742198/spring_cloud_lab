package org.yangbo.microservice.user.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yangbo.microservice.user.entity.ComplexRequest;
import org.yangbo.microservice.user.entity.Response;
import org.yangbo.microservice.user.entity.User;
import org.yangbo.microservice.user.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 测试泛型返回值
	 */
	@GetMapping("/gen")
	public Response<User> generalization() {
		Response<User> resp = new Response<User>();
		resp.setData(new User());
		resp.getData().setName("泛型用户");
		return resp;
	}
	
	@RequestMapping(value="/complex", method=RequestMethod.POST)
	public User complex(@RequestBody ComplexRequest complexRequest) throws UnknownHostException {
		log.debug("用户服务收到请求：{}", complexRequest);
		User user = complexRequest.getUser();
		user.setId(RandomUtils.nextLong());
		user.setName("processed complex :" + user.getName());
		log.info("ip: {}", InetAddress.getLocalHost());
		return user;
	}
	
	@GetMapping("/")
	public String index() {
		
		return "欢迎使用 User 服务！";
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User user = userRepository.findOne(id);
		return user;
	}
	
	@GetMapping("/name/{name}")
	public List<User> findByNameLike(@PathVariable String name) {
		List<User> users = userRepository.findByNameLike('%'+name+'%');
		return users;
	}
	
	@GetMapping("/age/{age}")
	public List<User> findByAge(@PathVariable Short age) {
		List<User> users = userRepository.findByAge(age);
		return users;
	}
	
	@GetMapping("/find")
	public void findBy(@RequestParam("id") Integer id, @RequestParam Map<String, Object> conditions) {
		log.info("Find Condition is {}", conditions);
	}
}
