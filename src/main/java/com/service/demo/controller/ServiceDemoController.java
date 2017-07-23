/**
 * 
 */
package com.service.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.demo.beans.Customer;
import com.service.demo.constants.Constants;
import com.service.demo.data.ServiceDataProvider;
import com.service.demo.processor.GetCardBalanceProcessor;
import com.service.demo.vo.BalanceRequestVO;
import com.service.demo.vo.BaseResponseVO;

/**
 * @author
 *
 */
@Controller
public class ServiceDemoController {

	private static final Logger logger = LoggerFactory.getLogger(ServiceDataProvider.class);

	@Autowired
	private ServiceDataProvider serviceDataProvider;

	@Autowired
	private GetCardBalanceProcessor getCardBalanceProcessor;

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public @ResponseBody Customer getAddress() {
		logger.info("Enering the method*****************");

		serviceDataProvider.loadData();

		Customer customer = new Customer();
		customer.setName("John");
		customer.setLocation("US");
		return customer;
	}

	@RequestMapping(value = "/accounts/getCardBalance", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseVO getCardBalance(HttpServletRequest request, HttpServletResponse response,
			@RequestBody BalanceRequestVO jsonRequest) {
		logger.info(Constants.ENTER);

		BaseResponseVO baseResponseVO = (BaseResponseVO) getCardBalanceProcessor.processRequest(request, response,
				jsonRequest);

		logger.info(Constants.EXIT);
		return baseResponseVO;
	}

}
