package jp1122;

public enum Tool {
	CHNS("Chainsaw", "Stihl", 1.99, true, false, true), LADW("Ladder", "Werner", 1.49, false, true, true),
	JAKD("Jackhammer", "DeWalt", 2.99, false, false, true), JAKR("Jackhammer", "Ridgid", 2.99, false, false, true);

	private String type;
	private String brand;
	private double dailyCharge;
	private boolean weekdayCharge;
	private boolean weekendCharge;
	private boolean holidayCharge;

	public static Tool getTool(String toolName) {
		switch (toolName) {
		case "CHNS":
			return CHNS;
		case "LADW":
			return LADW;
		case "JAKD":
			return JAKD;
		case "JAKR":
			return JAKR;
		default:
			return null;
		}
	}

	private Tool(String type, String brand, double dailyCharge, boolean weekdayCharge, boolean weekendCharge,
			boolean holidayCharge) {
		this.type = type;
		this.brand = brand;
		this.dailyCharge = dailyCharge;
		this.weekdayCharge = weekdayCharge;
		this.weekendCharge = weekendCharge;
		this.holidayCharge = holidayCharge;
	}

	public String getType() {
		return type;
	}

	public String getBrand() {
		return brand;
	}

	public double getDailyCharge() {
		return dailyCharge;
	}

	public boolean isWeekdayCharge() {
		return weekdayCharge;
	}

	public boolean isWeekendCharge() {
		return weekendCharge;
	}

	public boolean isHolidayCharge() {
		return holidayCharge;
	}

}
