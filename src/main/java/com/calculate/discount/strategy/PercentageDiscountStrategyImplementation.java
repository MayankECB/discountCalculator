package com.calculate.discount.strategy;

import com.calculate.discount.model.Invoice;
import com.calculate.discount.model.User;

public class PercentageDiscountStrategyImplementation implements CalculateDiscountStrategy {

	public PercentageDiscountStrategyImplementation() {
		
	}
	
	@Override
	public double applyDiscount(User user, Invoice invoice) {
		if(invoice.isGroceryPresent()) {
			return invoice.getFinalAmount(); // Discount not applicable on groceries item
		}
		
		double discountPercentage = 0;
        if (user.isEmployee()) {
            discountPercentage = 0.30;
        } else if (user.isAffiliate()) {
            discountPercentage = 0.10;
        } else if (user.isCustomerTenureOverTwoYears()) {
            discountPercentage = 0.05;
        }

        return invoice.getFinalAmount() - (invoice.getFinalAmount() * discountPercentage);
	}
}