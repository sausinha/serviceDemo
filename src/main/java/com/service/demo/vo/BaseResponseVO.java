package com.service.demo.vo;

import java.io.Serializable;
import java.util.Map;

public class BaseResponseVO implements Serializable {

	private static final long serialVersionUID = -6381651680114942782L;
	private String statusCode;
	private Map<String, Object> body;

	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the body
	 */
	public Map<String, Object> getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(Map<String, Object> body) {
		this.body = body;
	}

}
