package com.service.demo.vo;

import com.service.demo.beans.UserBean;

public class BalanceRequestVO extends BaseRequestVO {

	private static final long serialVersionUID = -8585552290039519116L;

	private String accountNumber;
	private String accountkey;
	private UserBean userId;

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountkey
	 */
	public String getAccountkey() {
		return accountkey;
	}

	/**
	 * @param accountkey
	 *            the accountkey to set
	 */
	public void setAccountkey(String accountkey) {
		this.accountkey = accountkey;
	}

	/**
	 * @return the userId
	 */
	public UserBean getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(UserBean userId) {
		this.userId = userId;
	}

}
