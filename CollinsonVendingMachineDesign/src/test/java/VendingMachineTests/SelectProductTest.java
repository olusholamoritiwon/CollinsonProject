package VendingMachineTests;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Vending.MoneyUtils;
import Vending.Product;
import Vending.VendingMachine;

public class SelectProductTest {

	private VendingMachine vendingMachine;

	@Before
	public void setUp() throws InterruptedException {

		vendingMachine.togglePowerButton();

		Assert.assertTrue("Vending machine should be turned on", vendingMachine.isPoweredOn());
	}

	@Test
	public void testFeatureSelectProduct() throws Exception {

		Assert.assertFalse("select a product with no money", vendingMachine.selectProduct("A"));

		vendingMachine.insertCoin(0.25);
		vendingMachine.insertCoin(0.25);
		vendingMachine.insertCoin(0.10);

		Assert.assertEquals("Should have enough for product A", MoneyUtils.newPrice(0.60),
				vendingMachine.getInsertedCoins());

		Assert.assertTrue("select a product and should get it", vendingMachine.selectProduct("A"));

		Assert.assertEquals("Should have no change", MoneyUtils.newPrice(0.00), vendingMachine.coinReturn());

		Map<String, Product> products = vendingMachine.getProducts();
		Product aProduct = products.get("A");

		Assert.assertEquals("Count of product should be less", 2, aProduct.getCount());

		vendingMachine.insertCoin(0.25);
		vendingMachine.insertCoin(0.25);
		vendingMachine.insertCoin(0.25);
		vendingMachine.insertCoin(0.25);

		Assert.assertEquals("Inserted coins is", MoneyUtils.newPrice(1.00), vendingMachine.getInsertedCoins());

		Assert.assertTrue("select a product and should get it", vendingMachine.selectProduct("C"));

		Assert.assertEquals("Should have change of", MoneyUtils.newPrice(0.20), vendingMachine.coinReturn());
		Assert.assertEquals("Now we've got the change, inserted coins should be", MoneyUtils.newPrice(0.00),
				vendingMachine.getInsertedCoins());

		products = vendingMachine.getProducts();
		Product cProduct = products.get("C");

		Assert.assertEquals("Bought the last one", 0, cProduct.getCount());

		vendingMachine.insertCoin(0.25);
		vendingMachine.insertCoin(0.25);
		vendingMachine.insertCoin(0.25);
		vendingMachine.insertCoin(0.25);

		Assert.assertFalse("Out of stock for product selection", vendingMachine.selectProduct("C"));

		Assert.assertFalse("Select a product that doesn't exist", vendingMachine.selectProduct("D"));

		Assert.assertEquals("Change should be ", MoneyUtils.newPrice(1.00), vendingMachine.coinReturn());

		Assert.assertEquals("Inserted coins is ", MoneyUtils.newPrice(0.00), vendingMachine.getInsertedCoins());
	}

}
