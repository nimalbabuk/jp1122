package jp1122;

import java.util.Arrays;

public class InputValidator {

	public static final boolean validateTool(String tool) {
		if (Arrays.asList(Tool.values()).contains(tool))
			return true;
		else
			return false;
	}

	public static final boolean validateRentalDays(int rentalDays) {
		if (rentalDays >= 1)
			return true;
		else
			return false;
	}

	public static boolean validateDiscountRate(int discountRate) {
		if (discountRate >= 0 && discountRate <= 100) {
			return true;
		} else {
			return false;
		}
	}

}
