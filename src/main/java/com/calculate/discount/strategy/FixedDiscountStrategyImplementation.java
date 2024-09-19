package com.calculate.discount.strategy;

import com.calculate.discount.model.Invoice;
import com.calculate.discount.model.User;

public class FixedDiscountStrategyImplementation implements CalculateDiscountStrategy {
	
	@Override
	public double applyDiscount(User user, Invoice invoice) {
		double discount = (int) (invoice.getFinalAmount() / 100) * 5; // For every $100 on the bill, a $ 5 discount 
        return invoice.getFinalAmount() - discount;
	}
	
	public FixedDiscountStrategyImplementation() {
		
	}
}