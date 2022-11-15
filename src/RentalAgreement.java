

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
	
	public String generateRentalAgreement() {
		LocalDate checkin = checkout.plusDays(days);		
		int chargeDays = getChargeDays(rentalTool, checkout, days);
		double fullCharge = chargeDays*rentalTool.getDailyCharge();
		double discountAmount = fullCharge * discount / 100;
		double finalCharge = fullCharge - discountAmount;
		
		StringBuilder rentalAgreement = new StringBuilder();
		rentalAgreement.append("Tool Code: " + rentalTool.toString());
		rentalAgreement.append("\nTool Type: "+ rentalTool.getType());
		rentalAgreement.append("\nTool brand: " + rentalTool.getBrand());
		rentalAgreement.append("\nRental Days: "+ days);
		rentalAgreement.append("\nCheckout Date: " + formatter.format(checkout));
		rentalAgreement.append("\nDue Date: " + formatter.format(checkin));
		rentalAgreement.append("\nDaily Charge: $" + rentalTool.getDailyCharge());
		rentalAgreement.append("\nCharge Days: " + chargeDays);
		rentalAgreement.append("\nPre-Discount Charge: " + fullCharge);
		rentalAgreement.append("\nDiscount Rate: " + discount + "%");
		rentalAgreement.append("\nDiscount Amount: $" + discountAmount);
		rentalAgreement.append("\nFinal Charge: $" + finalCharge);
		
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
