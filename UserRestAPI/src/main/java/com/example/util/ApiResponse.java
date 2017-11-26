package com.example.util;

import org.springframework.http.HttpStatus;

/**
 * @author biswa
 *
 */
public class ApiResponse {
	
	private String responseMsg;
	
	private String userId;
	
	private HttpStatus statusCode;
	
	private Boolean status;

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public ApiResponse(String responseMsg, String userId, HttpStatus statusCode, Boolean status) {
		super();
		this.responseMsg = responseMsg;
		this.userId = userId;
		this.statusCode = statusCode;
		this.status = status;
	}
	
	

}
