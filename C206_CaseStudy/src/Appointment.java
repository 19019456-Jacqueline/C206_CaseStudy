import java.time.LocalDateTime;

public class Appointment {

	private String customerName;
	private int customerID;
	private LocalDateTime appointmentDate;
	
	public Appointment(String customerName, int customerID, LocalDateTime appointmentDate){
		this.customerName = customerName;
		this.customerID = customerID;
		this.appointmentDate = appointmentDate;
	}
	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
		
	}
}