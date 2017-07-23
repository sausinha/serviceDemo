/**
 * 
 */
package com.service.demo.processor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.service.demo.constants.Constants;
import com.service.demo.data.beans.Customer;
import com.service.demo.data.beans.CustomerData;
import com.service.demo.data.beans.MasterAccountVO;
import com.service.demo.processor.helper.CustomerDataHelper;
import com.service.demo.vo.BalanceRequestVO;
import com.service.demo.vo.BaseResponseVO;

/**
 * @author ahmshaik
 *
 */
@Component("getCardBalanceProcessor")
public class GetCardBalanceProcessor extends BaseProcessor {

	private static final Logger logger = LoggerFactory.getLogger(GetCardBalanceProcessor.class);

	@Override
	public Object processRequest(HttpServletRequest request, HttpServletResponse response, Object jsonRequest) {
		logger.info(Constants.ENTER);

		BaseResponseVO responseVO = new BaseResponseVO();
		String statusCode = Constants.STATUS_ERROR;
		Map<String, Object> body = new HashMap<String, Object>();

		try {
			BalanceRequestVO balReqVO = (BalanceRequestVO) jsonRequest;

			CustomerData customerData = serviceDataProvider.getCustomerData();
			Customer customer = CustomerDataHelper.getCustomerByAcctNumber(customerData, balReqVO.getAccountNumber());

			body.put("accountVO", createCommandVO(customer));

			statusCode = Constants.STATUS_OK;
		} catch (Exception excep) {
			logger.error("Exception in GetCardBalanceProcessor ", excep);
		} finally {
			responseVO.setBody(body);
			responseVO.setStatusCode(statusCode);
		}

		logger.info(Constants.EXIT);
		return responseVO;
	}

	/**
	 * createCommandVO.
	 * 
	 * @param customer
	 * @return Customer
	 */
	private Customer createCommandVO(Customer customer) {
		Customer uiCust = new Customer();

		if (null != customer) {
			if (null != customer.getMasterAccountVO()) {
				MasterAccountVO masterAccountVO = customer.getMasterAccountVO();
				MasterAccountVO uiMasterAccountVO = new MasterAccountVO();
				uiMasterAccountVO.setCardAccountNumber(masterAccountVO.getCardAccountNumber());
				uiMasterAccountVO.setCurrentBalance(masterAccountVO.getCurrentBalance());
				uiMasterAccountVO.setCreditLimit(masterAccountVO.getCreditLimit());
				uiMasterAccountVO.setLastPaymentAmount(masterAccountVO.getLastPaymentAmount());
				uiMasterAccountVO.setLastPaymentDate(masterAccountVO.getLastPaymentDate());

				uiCust.setMasterAccountVO(masterAccountVO);
			}

		}

		return uiCust;
	}

	@Override
	public Object processRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
}
