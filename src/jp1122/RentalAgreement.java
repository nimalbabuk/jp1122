package jp1122;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class RentalAgreement {

	private static Tool rentalTool;
	private static int days;
	private static int discount;
	private static LocalDate checkout;
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	
	
	public RentalAgreement(String rentalTool, int days, int discount, LocalDate checkout) {
		super();
		this.rentalTool = Tool.getTool(rentalTool);
		this.days = days;
		this.discount = discount;
		this.checkout = checkout;
	}
	
	public static String generateRentalAgreement(String tool, int rentalDays, int discountRate, LocalDate checkoutDate) {
		LocalDate checkin = checkout.plusDays(days);		
		int chargeDays = getChargeDays(rentalTool, checkout, days);
		double fullCharge = chargeDays*rentalTool.getDailyCharge();
		double discountAmount = fullCharge * discount / 100;
		double finalCharge = fullCharge - discountAmount;
		
		StringBuilder rentalAgreement = new StringBuilder();
		rentalAgreement.append("Tool Code: " + rentalTool.toString());
		rentalAgreement.append("Tool Type: "+ rentalTool.getType());
		rentalAgreement.append("Tool brand: " + rentalTool.getBrand());
		rentalAgreement.append("Rental Days: "+ days);
		rentalAgreement.append("Checkout Date: " + formatter.format(checkout));
		rentalAgreement.append("Due Date: " + formatter.format(checkin));
		rentalAgreement.append("Daily Charge: $" + rentalTool.getDailyCharge());
		rentalAgreement.append("Charge Days: " + chargeDays);
		rentalAgreement.append("Pre-Discount Charge: " + fullCharge);
		rentalAgreement.append("Discount Rate: " + discount + "%");
		rentalAgreement.append("Discount Amount: $" + discountAmount);
		rentalAgreement.append("Final Charge: $" + finalCharge);
		
		return rentalAgreement.toString();
	}
	
	
	private static int getChargeDays(Tool rentalTool, LocalDate checkout, int days) {
		int chargeDays = 0;
		
		if(!rentalTool.isWeekdayCharge()) {
		    LocalDate result = checkout;
		    for(int i = 0; i < days; i++) {
		        result = result.plusDays(1);
		        if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
		            ++chargeDays;
		        }
		    }
		}
		else {
			chargeDays = days;
		}
		
		return chargeDays;
	}
}
