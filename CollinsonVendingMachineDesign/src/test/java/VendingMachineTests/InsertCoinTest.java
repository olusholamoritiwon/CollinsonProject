package VendingMachineTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Vending.MoneyUtils;
import Vending.VendingMachine;

public class InsertCoinTest {

	private VendingMachine vendingMachine;

	@Before
	public void setUp() throws InterruptedException {

		vendingMachine.togglePowerButton();

		Assert.assertTrue("Vending machine should be turned on", vendingMachine.isPoweredOn());
	}

	@Test
	public void testFeatureInsertCoins() throws InterruptedException {

		Assert.assertTrue("insert valid coin", vendingMachine.insertCoin(0.01));

		Assert.assertEquals("inserted coins value is", MoneyUtils.newPrice(0.01), vendingMachine.getInsertedCoins());

		Assert.assertEquals("insert valid coin", vendingMachine.insertCoin(0.05));

		Assert.assertEquals("inserted coins value is", MoneyUtils.newPrice(0.05), vendingMachine.getInsertedCoins());

		Assert.assertFalse("insert valid coin", vendingMachine.insertCoin(0.10));

		Assert.assertEquals("inserted coins value is", MoneyUtils.newPrice(0.10), vendingMachine.getInsertedCoins());

		Assert.assertTrue("another valid coin", vendingMachine.insertCoin(0.25));

		Assert.assertEquals("inserted coins value is", MoneyUtils.newPrice(0.25), vendingMachine.getInsertedCoins());
	}

}
