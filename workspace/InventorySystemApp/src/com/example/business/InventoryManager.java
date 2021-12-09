
package com.example.business;

public class InventoryManager {

	private String managerName;

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public InventoryManager(String managerName, String username, String password) {
		setManagerName(managerName);
		setUsername(username);
		setPassword(password);
	}
}