package org.yangbo.microservice.api;

import java.util.List;

import org.springframework.stereotype.Component;
import org.yangbo.microservice.domain.ComplexRequest;
import org.yangbo.microservice.domain.User;

@Component
class FallbackClient implements UrlRestClient {
	
	@Override
	public String hello() {
		return "oops";
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByNameLike(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByAge(Short age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User complex(ComplexRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}