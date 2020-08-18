
public class Requests {
	private int reqID;
	private int quotationID;
	private String name;
	private String description;
	private double amount;

	public Requests(int reqID, int quotationID, String name, String description, double amount) {
		this.reqID = reqID;
		this.quotationID = quotationID;
		this.name = name;
		this.description = description;
		this.amount = amount;
	}

	public int getReqID() {
		return reqID;
	}

	public void setReqID(int reqID) {
		this.reqID = reqID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQuotationID(int quotationID) {
		this.quotationID = quotationID;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getQuotationID() {
		return quotationID;
	}

	public double getAmount() {
		return amount;
	}

	
}
