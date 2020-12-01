package VendingMachineTests;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Vending.MoneyUtils;
import Vending.Product;
import Vending.VendingMachine;

public class GetProductListTest {

	private VendingMachine vendingMachine;

	@Before
	public void setUp() throws InterruptedException {

		vendingMachine.togglePowerButton();

		Assert.assertTrue("Vending machine should be turned on", vendingMachine.isPoweredOn());
	}

	@Test
	public void testFeatureGetProductList() throws InterruptedException {

		Map<String, Product> products = vendingMachine.getProducts();

		Assert.assertNotNull("Products should not be null", products);

		Assert.assertEquals("Vending Machine has 3 choices", 3, products.size());

		Product aProduct = products.get("A");

		Assert.assertEquals("A is a coke can", "Coke", aProduct.getName());

		Assert.assertEquals("Coke can is 50p", MoneyUtils.newPrice(0.60), aProduct.getPrice());

		Assert.assertEquals("There are 3 Coke cans left", 3, aProduct.getCount());

		Product bProduct = products.get("B");

		Assert.assertEquals("Pepsi", bProduct.getName());

		Assert.assertEquals(MoneyUtils.newPrice(0.80), bProduct.getPrice());

		Assert.assertEquals(2, bProduct.getCount());

		Product cProduct = products.get("C");

		Assert.assertEquals("Soda", cProduct.getName());

		Assert.assertEquals(MoneyUtils.newPrice(1.00), cProduct.getPrice());

		Assert.assertEquals(1, cProduct.getCount());
	}

}