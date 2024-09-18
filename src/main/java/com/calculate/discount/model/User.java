package com.calculate.discount.model;

public class User {
	private boolean isEmployee;
	private boolean isAffiliate;
	private boolean isCustomerTenureOverTwoYears;
	
	public User(boolean isEmployee, boolean isAffiliate, boolean isCustomerTenureOverTwoYears) {
		super();
		this.isEmployee = isEmployee;
		this.isAffiliate = isAffiliate;
		this.isCustomerTenureOverTwoYears = isCustomerTenureOverTwoYears;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public boolean isAffiliate() {
		return isAffiliate;
	}

	public boolean isCustomerTenureOverTwoYears() {
		return isCustomerTenureOverTwoYears;
	}
}
