package org.yangbo.microservice.api;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.ListUtils;
import org.springframework.stereotype.Service;
import org.yangbo.microservice.domain.ComplexRequest;
import org.yangbo.microservice.domain.Response;
import org.yangbo.microservice.domain.User;

@Service
public class UserServiceFallback implements UserService {

	private User fallbackUser = new User();
	
	public UserServiceFallback(){
		fallbackUser.setName("fallback user");
	}
	
	@Override
	public User findById(Long id) {
		return fallbackUser;
	}

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
