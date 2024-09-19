package com.calculate.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.calculate.discount.model.Invoice;
import com.calculate.discount.model.User;
import com.calculate.discount.service.CalculateDiscountService;
import com.calculate.discount.strategy.FixedDiscountStrategyImplementation;
import com.calculate.discount.strategy.PercentageDiscountStrategyImplementation;

public class DiscountCalculatorApplicationTests {

	@Mock
    private FixedDiscountStrategyImplementation fixedDiscountStrategy;

    @Mock
    private PercentageDiscountStrategyImplementation percentageDiscountStrategy;

    @Mock
    private User user;
    
    @Mock
    private Invoice invoice;

    @InjectMocks
    private CalculateDiscountService calculateDiscountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testCalculateNetAmount_WithEmployeeDiscount() throws ExecutionException, InterruptedException {
        // Arrange: Mock the percentage and fixed discount strategies
        Invoice invoice = new Invoice(1000,800,200, null);  // total $1000, 800 non-groceries, 200 groceries

        when(percentageDiscountStrategy.applyDiscount(user, invoice)).thenReturn(760.0);  // 30% discount applied
        when(fixedDiscountStrategy.applyDiscount(user, invoice)).thenReturn(725.0);  // Additional $35 discount

        // Act: Call the service to calculate the net amount
        CompletableFuture<Double> resultFuture = calculateDiscountService.calculateNetAmount(user, invoice);
        double netAmount = resultFuture.get();  // Get the result

        // Assert: Verify the results
        assertEquals(725.0, netAmount);

        // Verify that both strategies were invoked
        verify(percentageDiscountStrategy).applyDiscount(user, invoice);
        verify(fixedDiscountStrategy).applyDiscount(user, invoice);
    }

    @Test
    public void testCalculateNetAmount_WithAffiliateDiscount() throws ExecutionException, InterruptedException {
        // Arrange: Mock the percentage and fixed discount strategies
    	Invoice invoice = new Invoice(1600, 1000, 600, null);  // Groceries, total $1000

        when(percentageDiscountStrategy.applyDiscount(user, invoice)).thenReturn(1500.0);  // 10% discount applied
        when(fixedDiscountStrategy.applyDiscount(user, invoice)).thenReturn(1625.0);  // Additional $75 discount

        // Act: Call the service to calculate the net amount
        CompletableFuture<Double> resultFuture = calculateDiscountService.calculateNetAmount(user, invoice);
        double netAmount = resultFuture.get();  // Get the result

        // Assert: Verify the results
        assertEquals(1625.0, netAmount);

        // Verify that both strategies were invoked
        verify(percentageDiscountStrategy).applyDiscount(user, invoice);
        verify(fixedDiscountStrategy).applyDiscount(user, invoice);
    }

    @Test
    public void testCalculateNetAmount_NoPercentageDiscount() throws ExecutionException, InterruptedException {
        // Arrange: Mock the percentage and fixed discount strategies
        Invoice invoice = new Invoice(1000, 800, 200, null);  // Groceries, total $1000

        when(percentageDiscountStrategy.applyDiscount(user, invoice)).thenReturn(1000.0);  // No percentage discount applied 
        when(fixedDiscountStrategy.applyDiscount(user, invoice)).thenReturn(955.0);  // $45 discount on $1000

        // Act: Call the service to calculate the net amount
        CompletableFuture<Double> resultFuture = calculateDiscountService.calculateNetAmount(user, invoice);
        double netAmount = resultFuture.get();  // Get the result

        // Assert: Verify the results
        assertEquals(955.0, netAmount);

        // Verify that both strategies were invoked
        verify(percentageDiscountStrategy).applyDiscount(user, invoice);
        verify(fixedDiscountStrategy).applyDiscount(user, invoice);
    }
}
