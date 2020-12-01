package Vending;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//we are declaring public API for Vending Machine

public class VendingMachine {

	private static final List<BigDecimal> ACCEPTED_COINS = setAcceptedCoins();
	private static final double ZERO_PRICE = 0.00;

	private boolean poweredOn;
	private Map<String, Product> products;
	private BigDecimal insertedCoins;

	public VendingMachine() {
		products = initialiseProducts();
		insertedCoins = MoneyUtils.newPrice(ZERO_PRICE);
	}

	public boolean isPoweredOn() {
		return poweredOn;
	}

	public void togglePowerButton() {
		this.poweredOn = !poweredOn;
	}

	public Map<String, Product> getProducts() {
		return products;
	}

	public boolean insertCoin(final double coin) {
		BigDecimal insertedCoin = MoneyUtils.newPrice(coin);

		if (ACCEPTED_COINS.contains(insertedCoin)) {
			insertedCoins = insertedCoins.add(insertedCoin);
			return true;
		}

		return false;
	}

	public BigDecimal getInsertedCoins() {
		return insertedCoins;
	}

	public boolean selectProduct(String productCode) {
		Product selectedProduct = products.get(productCode);

		if (selectedProduct != null && selectedProduct.hasStock()
				&& MoneyUtils.hasEnoughMoney(insertedCoins, selectedProduct.getPrice())) {

			insertedCoins = insertedCoins.subtract(selectedProduct.getPrice());
			selectedProduct.setCount(selectedProduct.getCount() - 1);
			products.put(productCode, selectedProduct);

			return true;
		}

		return false;
	}

	public BigDecimal coinReturn() {
		BigDecimal change = insertedCoins;
		insertedCoins = MoneyUtils.newPrice(ZERO_PRICE);
		return change;
	}

	private Map<String, Product> initialiseProducts() {
		Map<String, Product> setupProducts = new HashMap<String, Product>();
		setupProducts.put("A", new Product("Coke", 0.60, 3));
		setupProducts.put("B", new Product("Pepsi", 0.80, 2));
		setupProducts.put("C", new Product("Soda", 1.00, 1));
		return setupProducts;
	}

	private static List<BigDecimal> setAcceptedCoins() {

		List<BigDecimal> acceptedCoins = new ArrayList<BigDecimal>();
		acceptedCoins.add(MoneyUtils.newPrice(0.01));
		acceptedCoins.add(MoneyUtils.newPrice(0.05));
		acceptedCoins.add(MoneyUtils.newPrice(0.10));
		acceptedCoins.add(MoneyUtils.newPrice(0.25));

		return acceptedCoins;
	}
}
