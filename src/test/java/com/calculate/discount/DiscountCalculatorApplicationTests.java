package com.calculate.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.calculate.discount.model.Invoice;
import com.calculate.discount.model.User;
import com.calculate.discount.service.CalculateDiscountService;

@SpringBootTest
class DiscountCalculatorApplicationTests {

	@Autowired
    private CalculateDiscountService discountService;

    @Test
    public void testEmployeeDiscount() throws ExecutionException, InterruptedException {
        User user = new User(true, false, false);
        Invoice invoice = new Invoice(1000, false);
        double netAmount = discountService.calculateNetAmount(user, invoice).get();
        assertEquals(665, netAmount); // 30% discount + $45 fixed discount
    }

    @Test
    public void testAffiliateDiscount() throws ExecutionException, InterruptedException {
        User user = new User(false, true, false);
        Invoice Invoice = new Invoice(500, false);
        double netAmount = discountService.calculateNetAmount(user, Invoice).get();
        assertEquals(440, netAmount); // 10% discount + $20 fixed discount
    }

    @Test
    public void testCustomerOverTwoYearsDiscount() throws ExecutionException, InterruptedException {
        User user = new User(false, false, true);
        Invoice Invoice = new Invoice(250, false);
        double netAmount = discountService.calculateNetAmount(user, Invoice).get();
        assertEquals(230, netAmount); // 5% discount + $10 fixed discount
    }

    @Test
    public void testNoPercentageDiscountOnGroceries() throws ExecutionException, InterruptedException {
        User user = new User(true, false, false);
        Invoice Invoice = new Invoice(1000, true); // groceries
        double netAmount = discountService.calculateNetAmount(user, Invoice).get();
        assertEquals(955, netAmount); // Only fixed discount of $45 applies
    }

}
