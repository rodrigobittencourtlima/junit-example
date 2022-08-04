package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {

	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		double amount = 200.00;
		double expectedValeu = 196.00;
		Account acc = new Account(1L, 0.00);

		acc.deposit(amount);

		Assertions.assertEquals(expectedValeu, acc.getBalance());
	}

	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		double amount = -200.00;
		double expectedValeu = 100.00;
		Account acc = new Account(1L, expectedValeu);

		acc.deposit(amount);

		Assertions.assertEquals(expectedValeu, acc.getBalance());
	}

}
