package com.calculate.discount;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.calculate.discount.model.Invoice;
import com.calculate.discount.model.User;
import com.calculate.discount.service.CalculateDiscountService;
import com.calculate.discount.strategy.FixedDiscountStrategyImplementation;
import com.calculate.discount.strategy.PercentageDiscountStrategyImplementation;

@SpringBootTest
public class DiscountCalculatorApplicationTests {

    @Mock
    private PercentageDiscountStrategyImplementation percentageDiscountStrategy;

    @Mock
    private FixedDiscountStrategyImplementation fixedAmountDiscountStrategy;

    @InjectMocks
    private CalculateDiscountService discountService;

    @BeforeEach
    public void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateNetAmount_WithEmployeeDiscount() throws ExecutionException, InterruptedException {
        // Arrange: Mock the percentage and fixed discount strategies
        User user = new User(true, false, false);  // Employee
        Invoice bill = new Invoice(1000, false);  // No groceries, total $1000

        when(percentageDiscountStrategy.applyDiscount(user, bill)).thenReturn(700.0);  // 30% discount applied
        when(fixedAmountDiscountStrategy.applyDiscount(user, bill)).thenReturn(655.0);  // Additional $45 discount

        // Act: Call the service to calculate the net amount
        CompletableFuture<Double> resultFuture = discountService.calculateNetAmount(user, bill);
        double netAmount = resultFuture.get();  // Get the result

        // Assert: Verify the results
        assertEquals(655.0, netAmount);

        // Verify that both strategies were invoked
        verify(percentageDiscountStrategy).applyDiscount(user, bill);
        verify(fixedAmountDiscountStrategy).applyDiscount(user, bill);
    }

    @Test
    public void testCalculateNetAmount_WithAffiliateDiscount() throws ExecutionException, InterruptedException {
        // Arrange: Mock the percentage and fixed discount strategies
        User user = new User(false, true, false);  // Affiliate
        Invoice bill = new Invoice(500, false);  // No groceries, total $500

        when(percentageDiscountStrategy.applyDiscount(user, bill)).thenReturn(450.0);  // 10% discount applied
        when(fixedAmountDiscountStrategy.applyDiscount(user, bill)).thenReturn(425.0);  // Additional $25 discount

        // Act: Call the service to calculate the net amount
        CompletableFuture<Double> resultFuture = discountService.calculateNetAmount(user, bill);
        double netAmount = resultFuture.get();  // Get the result

        // Assert: Verify the results
        assertEquals(425.0, netAmount);

        // Verify that both strategies were invoked
        verify(percentageDiscountStrategy).applyDiscount(user, bill);
        verify(fixedAmountDiscountStrategy).applyDiscount(user, bill);
    }

    @Test
    public void testCalculateNetAmount_WithGroceries_NoPercentageDiscount() throws ExecutionException, InterruptedException {
        // Arrange: Mock the percentage and fixed discount strategies
        User user = new User(true, false, false);  // Employee
        Invoice bill = new Invoice(1000, true);  // Groceries, total $1000

        when(percentageDiscountStrategy.applyDiscount(user, bill)).thenReturn(1000.0);  // No percentage discount applied on groceries
        when(fixedAmountDiscountStrategy.applyDiscount(user, bill)).thenReturn(955.0);  // $45 discount on $1000

        // Act: Call the service to calculate the net amount
        CompletableFuture<Double> resultFuture = discountService.calculateNetAmount(user, bill);
        double netAmount = resultFuture.get();  // Get the result

        // Assert: Verify the results
        assertEquals(955.0, netAmount);

        // Verify that both strategies were invoked
        verify(percentageDiscountStrategy).applyDiscount(user, bill);
        verify(fixedAmountDiscountStrategy).applyDiscount(user, bill);
    }
}
