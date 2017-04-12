package com.github.constants;

/**
 * Constants
 * 
 * @author Timóteo Soutello
 *
 */
public enum DatabaseConstants {
	USER("postgres"), 
	PASSWORD("admin"), 
	DRIVER("org.postgresql.Driver"), 
	URL("jdbc:postgresql://localhost:5432/javajdbcDB");

	private String value;

	DatabaseConstants(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
