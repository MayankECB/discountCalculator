package com.calculate.discount.model;

public class Invoice {
	private double finalAmount;
	private double groceryAmount;
	private double nonGroceryAmount;
	private Product[] product;
	
	public Invoice(double finalAmount, double groceryAmount, double nonGroceryAmount, Product[] product) {
		super();
		this.finalAmount = finalAmount;
		this.groceryAmount = groceryAmount;
		this.nonGroceryAmount = nonGroceryAmount;
		this.product = product;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public double getGroceryAmount() {
		return groceryAmount;
	}

	public void setGroceryAmount(double groceryAmount) {
		this.groceryAmount = groceryAmount;
	}

	public double getNonGroceryAmount() {
		return nonGroceryAmount;
	}

	public void setNonGroceryAmount(double nonGroceryAmount) {
		this.nonGroceryAmount = nonGroceryAmount;
	}

	public Product[] getProduct() {
		return product;
	}

	public void setProduct(Product[] product) {
		this.product = product;
	}
}
