package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		double amount = 200.00;
		double expectedValue = 196.00;
		Account acc = AccountFactory.createEmptyAccount();

		acc.deposit(amount);

		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		double amount = -200.00;
		double expectedValue = 100.00;
		Account acc = AccountFactory.createAccount(expectedValue);

		acc.deposit(amount);

		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		double initialBalance = 800.00;
		double expectedValue = 0.0;
		Account acc = AccountFactory.createAccount(initialBalance);

		double result = acc.fullWithdraw();

		Assertions.assertEquals(result, initialBalance);
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		double initialBalance = 800.00;
		double amount = 200.00;
		double expectedValue = 600.00;
		Account acc = AccountFactory.createAccount(initialBalance);

		acc.withdraw(amount);

		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.00);

			acc.withdraw(801.00);
		});
	}

}
