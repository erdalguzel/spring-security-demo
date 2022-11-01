package dev.springsecurity.demo.enumeration;

public enum UserRole {
	EMPLOYEE("EMPLOYEE"), MANAGER("MANAGER"), ADMIN("ADMIN");

	private String key;

	private UserRole(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}