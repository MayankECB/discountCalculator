package com.calculate.discount.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.calculate.discount.model.Invoice;
import com.calculate.discount.model.User;
import com.calculate.discount.strategy.FixedDiscountStrategyImplementation;
import com.calculate.discount.strategy.PercentageDiscountStrategyImplementation;

@Service
public class CalculateDiscountService {

	private final FixedDiscountStrategyImplementation fixedDiscountStrategyImplementation;
	private final PercentageDiscountStrategyImplementation percentageDiscountStrategyImplementation;
	
	public CalculateDiscountService(FixedDiscountStrategyImplementation fixedDiscountServiceImplementation,
			PercentageDiscountStrategyImplementation percentageDiscountServiceImplementation) {
		this.fixedDiscountStrategyImplementation = fixedDiscountServiceImplementation;
		this.percentageDiscountStrategyImplementation = percentageDiscountServiceImplementation;
	}
	
	@Async
    public CompletableFuture<Double> calculateNetAmount(User user, Invoice invoice) {
        double percentageDiscountedAmount = percentageDiscountStrategyImplementation.applyDiscount(user, invoice);
        double fixedDiscountedAmount = fixedDiscountStrategyImplementation.applyDiscount(user, new Invoice(percentageDiscountedAmount, invoice.isGroceryPresent()));

        return CompletableFuture.completedFuture(fixedDiscountedAmount);
    }
}
