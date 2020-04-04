package com.numerx.formutil.weixin.company.entity;

/**
 * 凭证
 */
public class Token {
	
	// 接口访问凭证
	private String accessToken;
	
	// 凭证有效期，单位：秒
	private int expiresIn = 0;

	/**
	 * 有效期的开始时间，单位：毫秒
	 */
	private long startTime = 0;
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
}
