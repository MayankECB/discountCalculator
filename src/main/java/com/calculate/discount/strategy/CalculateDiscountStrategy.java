package com.calculate.discount.strategy;

import com.calculate.discount.model.Invoice;
import com.calculate.discount.model.User;

public interface CalculateDiscountStrategy {
	double applyDiscount(User user, Invoice invoice);
}
