package com.huajin.zuulserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class RouteFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(RouteFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>>route<<< %s", request.getMethod(), request.getRequestURL().toString()));
		return null;
	}

	@Override
	public String filterType() {
		return "route";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
