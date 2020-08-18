import java.util.Date;

public class Package {
	private String description;
	private String packageCode;
	private double packageAmount;
	private String startDate;
	private String endDate;
	private boolean isAvailable;
	
	public Package(String description, String packageCode, double packageAmount, String startDate, String endDate, boolean isAvailable) {
		this.description = description;
		this.packageCode = packageCode;
		this.packageAmount = packageAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isAvailable = true;
	}
	
	public String getDescription() {
		return description;
	}
	public String getpCode() {
		return packageCode;
	}
	public double getpackageAmount() {
		return packageAmount;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	
	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
	
	
}
