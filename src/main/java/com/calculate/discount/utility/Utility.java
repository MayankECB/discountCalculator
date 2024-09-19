package com.calculate.discount.utility;

import com.calculate.discount.model.User;

public class Utility {

	public double fetchEligibleDiscount(User user) {
		
		// call db to check whether user is an employee or an affiliate or customer over two years
		
		// if user is an employee
		// return 0.3 // 30% discount
		
		// if user is an affiliate
		// return 0.1 // 10% discount
		
		// if user is customer over two years
		// return 0.05 // 5% discount		
		
		return 0.0; // for all other scenarios
	}
}
