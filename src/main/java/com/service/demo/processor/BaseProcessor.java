package com.service.demo.processor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.service.demo.data.ServiceDataProvider;

public abstract class BaseProcessor {

	@Autowired
	protected ServiceDataProvider serviceDataProvider;

	public abstract Object processRequest(HttpServletRequest request, HttpServletResponse response);

	public abstract Object processRequest(HttpServletRequest request, HttpServletResponse response, Object jsonRequest);

}
