package VendingMachineTests;

import org.junit.Test;

import Vending.MoneyUtils;

public class MoneyUtilsTest {

	@Test(expected = InstantiationError.class)
	public void testInstantiateCurrenctUtils() throws Exception {
		new MoneyUtils();
	}

}
