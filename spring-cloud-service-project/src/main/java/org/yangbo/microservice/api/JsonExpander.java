package org.yangbo.microservice.api;

import com.alibaba.fastjson.JSONObject;

import feign.Param.Expander;

public class JsonExpander implements Expander {

	@Override
	public String expand(Object value) {
		return JSONObject.toJSONString(value);
	}

}
