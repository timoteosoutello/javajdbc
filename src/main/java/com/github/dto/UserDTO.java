package com.github.dto;

/**
 * 
 * @author Timóteo Soutello
 *
 */
public class UserDTO {

	private String username;
	private Integer age;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @param username
	 * @param age
	 */
	public UserDTO(String username, Integer age) {
		super();
		this.username = username;
		this.age = age;
	}
}
