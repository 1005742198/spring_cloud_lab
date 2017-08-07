package org.yangbo.microservice.domain;

/**
 * 一个测试参数
 * 
 * @author bo.yang
 *
 */
public class Global {
	
	private int exchangeId;
	private String globalTransactionId;
	private User user;
	
	public int getExchangeId() {
		return exchangeId;
	}
	public void setExchangeId(int exchangeId) {
		this.exchangeId = exchangeId;
	}
	public String getGlobalTransactionId() {
		return globalTransactionId;
	}
	public void setGlobalTransactionId(String globalTransactionId) {
		this.globalTransactionId = globalTransactionId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
