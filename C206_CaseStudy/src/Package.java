import java.util.Date;

public class Package {
	private String description;
	private String pCode;
	private int pAmount;
	private String startDate;
	private String endDate;
	private boolean isAvailable;
	
	public Package(String description, String pCode, int pAmount, String startDate, String endDate, boolean isAvailable) {
		this.description = description;
		this.pCode = pCode;
		this.pAmount = pAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isAvailable = true;
	}
	
	public String getDescription() {
		return description;
	}
	public String getpCode() {
		return pCode;
	}
	public int getpAmount() {
		return pAmount;
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
