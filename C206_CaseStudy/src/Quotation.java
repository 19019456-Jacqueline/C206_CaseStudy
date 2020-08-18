public class Quotation {
	private int reqID;
	private int quotationID;
	private String category;
	private String description;
	private String name;
	private String date;
	private double amount;

	public Quotation(int reqID, int quotationID, String category, String description, String name, String date, double amount) {
		this.reqID = reqID;
		this.quotationID = quotationID;
		this.category = category;
		this.description = description;
		this.name = name;
		this.date = date;
		this.amount = amount;
	}

	public int getRequestID() {
		return reqID;
	}

	public int getQuotationID() {
		return quotationID;
	}

	public String getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

}