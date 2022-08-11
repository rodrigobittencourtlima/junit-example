package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTests {

	@Test
	public void constructorShouldCreateEntityWhenValidData() {
		Financing financing = new Financing(100000.00, 2000.00, 80);

		Assertions.assertNotNull(financing);
	}

	@Test
	public void constructorShouldThrowExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Financing(100000.00, 2000.00, 20));
	}

	@Test
	public void setTotalAmountShouldUpdateWhenValidValue() {
		double newTotalAmount = 80000.00;
		Financing financing = new Financing(100000.00, 2000.00, 80);

		financing.setTotalAmount(newTotalAmount);

		Assertions.assertEquals(newTotalAmount, financing.getTotalAmount());
	}

	@Test
	public void setTotalAmountShouldThrowExceptionWhenInvalidValue() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = new Financing(100000.00, 2000.00, 80);
			financing.setTotalAmount(200000.00);
		});
	}

	@Test
	public void setIncomeShouldUpdateWhenValidValue() {
		double newIncome = 2500.00;
		Financing financing = new Financing(100000.00, 2000.00, 80);

		financing.setIncome(newIncome);

		Assertions.assertEquals(newIncome, financing.getIncome());
	}

	@Test
	public void setIncomeShouldThrowExceptionWhenInvalidValue() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = new Financing(100000.00, 2000.00, 80);
			financing.setIncome(1500.00);
		});
	}

	@Test
	public void setMonthsShouldUpdateWhenValidValue() {
		int newMonths = 90;
		Financing financing = new Financing(100000.00, 2000.00, 80);

		financing.setMonths(newMonths);

		Assertions.assertEquals(newMonths, financing.getMonths());
	}

	@Test
	public void setMonthsShouldThrowExceptionWhenInvalidValue() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = new Financing(100000.00, 2000.00, 80);
			financing.setMonths(50);
		});
	}

	@Test
	public void entryShouldReturnCalculatedEntryValue() {
		double expectedEntryValue = 40000.00;
		Financing financing = new Financing(200000.00, 5000.00, 80);

		double result = financing.entry();

		Assertions.assertEquals(expectedEntryValue, result);
	}

	@Test
	public void quotaShouldReturnCalculatedQuotaValue() {
		double expectedQuotaValue = 2000.00;
		Financing financing = new Financing(200000.00, 4000.00, 80);

		double result = financing.quota();

		Assertions.assertEquals(expectedQuotaValue, result);
	}

}
