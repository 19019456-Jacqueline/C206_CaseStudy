
public class userAccounts {
	private String name;
	private String role;
	private String email;
	private String password;
	private String status;
	
	public userAccounts(String name, String role, String email, String password, String status) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getStatus() {
		return status;
	}
}
