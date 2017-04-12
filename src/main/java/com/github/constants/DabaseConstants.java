package com.github.constants;

/**
 * Constants
 * @author Timóteo Soutello
 *
 */
public enum DabaseConstants {
	DATABASE_NAME("TESTE");
	private String value;

	DabaseConstants(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
