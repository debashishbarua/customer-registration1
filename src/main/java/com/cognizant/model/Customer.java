package com.cognizant.model;

public class Customer {
	
	private long custId;
	private String custName;
	private String custEmail;
	private String custPhoneNo;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(long custId, String custName, String custEmail, String custPhoneNo) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custPhoneNo = custPhoneNo;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPhoneNo() {
		return custPhoneNo;
	}

	public void setCustPhoneNo(String custPhoneNo) {
		this.custPhoneNo = custPhoneNo;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custPhoneNo="
				+ custPhoneNo + "]";
	}

}
