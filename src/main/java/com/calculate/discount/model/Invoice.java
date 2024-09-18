package com.calculate.discount.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

//@AllArgsConstructor
//@Getter
public class Invoice {
	private double finalAmount;
    private boolean isGroceryPresent;
 
    public Invoice(double finalAmount, boolean isGroceryPresent) {
		this.finalAmount = finalAmount;
		this.isGroceryPresent = isGroceryPresent;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public boolean isGroceryPresent() {
		return isGroceryPresent;
	}
}
