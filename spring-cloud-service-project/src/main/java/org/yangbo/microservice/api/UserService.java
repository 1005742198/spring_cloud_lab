package org.yangbo.microservice.api;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.ListUtils;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yangbo.microservice.MyFeignConfigure;
import org.yangbo.microservice.domain.ComplexRequest;
import org.yangbo.microservice.domain.Response;
import org.yangbo.microservice.domain.User;

@FeignClient(name = "user-service"/*, 
configuration = MyFeignConfigure.class,
fallback = UserServiceFallback.class*/)
public interface UserService {

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);

	@RequestMapping(value = "/user/name/{name}", method = RequestMethod.GET)
	public List<User> findByNameLike(@PathVariable("name") String name);

	@RequestMapping(value = "/user/age/{age}", method = RequestMethod.GET)
	public List<User> findByAge(@PathVariable("age") Short age);

	@RequestMapping(value = "/user/complex", method = RequestMethod.POST, consumes = "application/json")
	public User complex(ComplexRequest request);

	@RequestMapping(value = "/user/find", method = RequestMethod.GET)
	public void findBy(@RequestParam("id") Integer id, @RequestParam Map<String, Object> conditions);

	@RequestMapping(value = "/user/gen", method = RequestMethod.GET)
	public Response<User> testGen();

	/*
	 * feign contract
	 * 
	 * @RequestLine("GET /user/{id}") public User findById(@Param("id") Long
	 * id);
	 * 
	 * @RequestLine("GET /user/name/{name}") public List<User>
	 * findByNameLike(@Param("name") String name);
	 * 
	 * @RequestLine("GET /user/{age}") public List<User> findByAge(@Param("age")
	 * Short age);
	 * 
	 * // complex
	 * 
	 * @RequestLine("POST /user/complex")
	 * 
	 * @Headers("Content-Type: application/json") // json curly braces must be
	 * escaped!
	 * 
	 * @Body("%7B\"user\": \"{user}\", \"global\": \"{global}\"%7D") public User
	 * complex(@Param(value="user") User user,
	 * 
	 * @Param(value="global") Global global);
	 */
}

@Component
class UserServiceFallbackEmbedded implements UserService {

	private User fallbackUser = new User();

	public UserServiceFallbackEmbedded() {
		fallbackUser.setName("fallback user");
	}

	@Override
	public User findById(Long id) {
		return fallbackUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByNameLike(String name) {
		return ListUtils.EMPTY_LIST;
	}

	@Override
	public User complex(ComplexRequest request) {
		return fallbackUser;
	}

	@Override
	public List<User> findByAge(Short age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findBy(Integer id, Map<String, Object> conditions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Response<User> testGen() {
		// TODO Auto-generated method stub
		return null;
	}

}
