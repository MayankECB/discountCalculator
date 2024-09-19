package com.calculate.discount.strategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.calculate.discount.model.Invoice;
import com.calculate.discount.model.Product;
import com.calculate.discount.model.User;
import com.calculate.discount.utility.Utility;

public class PercentageDiscountStrategyImplementation implements CalculateDiscountStrategy {

	@Value("${product.grocery.ids}")
	private List<String> groceryIds;

	@Autowired
	private Utility utility;
	
	@Autowired
	private Invoice invoice;
	
	public PercentageDiscountStrategyImplementation() {
		
	}
	
	@Override
	public double applyDiscount(User user, Invoice invoice) {
		Product[] products = invoice.getProduct();
		double groceryItemsPrice = 0.0;
		double nonGroceryItemsPrice = 0.0;
		for (Product product : products) {
		    if(groceryIds.contains(product.getId())) {
		    	groceryItemsPrice = groceryItemsPrice + product.getPrice();
		    }else {
		    	nonGroceryItemsPrice = nonGroceryItemsPrice + product.getPrice();
		    }
		}
		invoice.setFinalAmount(groceryItemsPrice + nonGroceryItemsPrice*(1-utility.fetchEligibleDiscount(user)));
		invoice.setGroceryAmount(groceryItemsPrice);
		invoice.setNonGroceryAmount(nonGroceryItemsPrice);
		
		return invoice.getFinalAmount();
	}
}