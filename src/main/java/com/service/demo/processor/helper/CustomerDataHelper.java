/**
 * 
 */
package com.service.demo.processor.helper;

import com.service.demo.data.beans.Customer;
import com.service.demo.data.beans.CustomerData;

/**
 * @author ahmshaik
 *
 */
public class CustomerDataHelper {

	/**
	 * getCustomerByAcctKey
	 * 
	 * @param custData
	 * @param accountKey
	 * @return Customer
	 */
	public static Customer getCustomerByAcctKey(CustomerData custData, String accountKey) {
		Customer customer = null;
		if (null != custData && null != custData.getCustomerVOList()) {
			for (Customer cust : custData.getCustomerVOList()) {
				if (cust.getAccountKey().equals(accountKey)) {
					customer = cust;
					break;
				}
			}
		}
		return customer;
	}

	/**
	 * getCustomerByAcctNumber
	 * 
	 * @param custData
	 * @param accountNumber
	 * @return Customer
	 */
	public static Customer getCustomerByAcctNumber(CustomerData custData, String accountNumber) {
		Customer customer = null;
		if (null != custData && null != custData.getCustomerVOList()) {
			for (Customer cust : custData.getCustomerVOList()) {
				if (cust.getMasterAccountVO().getCardAccountNumber().equals(accountNumber)) {
					customer = cust;
					break;
				}
			}
		}
		return customer;
	}

}
