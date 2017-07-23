package com.service.demo.data.beans;

public class Customer {

	private String accountKey;
	private MasterAccountVO masterAccountVO;

	/**
	 * @return the accountKey
	 */
	public String getAccountKey() {
		return accountKey;
	}

	/**
	 * @param accountKey
	 *            the accountKey to set
	 */
	public void setAccountKey(String accountKey) {
		this.accountKey = accountKey;
	}

	/**
	 * @return the masterAccountVO
	 */
	public MasterAccountVO getMasterAccountVO() {
		return masterAccountVO;
	}

	/**
	 * @param masterAccountVO
	 *            the masterAccountVO to set
	 */
	public void setMasterAccountVO(MasterAccountVO masterAccountVO) {
		this.masterAccountVO = masterAccountVO;
	}
	
	@Override
	public String toString() {
		return "Customer [accountKey =" + accountKey + ", masterAccountVO = " + masterAccountVO + "]";
	}

}
