import java.time.LocalDateTime;

public class Quotation {
	private int reqID;
	private int quotationID;
	private String category;
	private String description;
	private String name;
	private LocalDateTime date;
	private double amount;

	public Quotation(int reqID, int quotationID, String category, String description, String name, LocalDateTime date, double amount) {
		this.reqID = reqID;
		this.quotationID = quotationID;
		this.category = category;
		this.description = description;
		this.name = name;
		this.date = date;
		this.amount = amount;
	}

	public int getReqID() {
		return reqID;
	}

	public int getQuotationID() {
		return quotationID;
	}

	public void setQuotationID(int quotationID) {
		this.quotationID = quotationID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


}