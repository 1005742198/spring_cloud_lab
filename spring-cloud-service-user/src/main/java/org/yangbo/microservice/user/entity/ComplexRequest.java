package org.yangbo.microservice.user.entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ComplexRequest {
	
	private User user;
	private Global global;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Global getGlobal() {
		return global;
	}
	public void setGlobal(Global global) {
		this.global = global;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
