package org.yangbo.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.support.SpringMvcContract;

import feign.MethodMetadata;

public class RpcLikeContract extends SpringMvcContract {

	@Override
	public List<MethodMetadata> parseAndValidatateMetadata(Class<?> targetType) {
		return super.parseAndValidatateMetadata(targetType);
	}
}
