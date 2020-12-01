package Vending;

import java.math.BigDecimal;

public class MoneyUtils {

	private static final int SCALE = 2;
	private static final int THE_SAME = 0;

	public MoneyUtils() {
		throw new InstantiationError("Utility class, do not instantiate");
	}

	public static BigDecimal newPrice(double price) {
		return new BigDecimal(price).setScale(SCALE);
	}

	public static boolean hasEnoughMoney(BigDecimal currentMoney, BigDecimal price) {
		if (currentMoney.compareTo(price) >= THE_SAME) {
			return true;
		}
		return false;
	}
}
