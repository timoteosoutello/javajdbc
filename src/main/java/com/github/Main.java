package com.github;

import java.sql.SQLException;

import com.github.service.impl.DatabaseServiceImpl;

/**
 * 
 * @author Timóteo Soutello
 *
 */
public class Main {

	/**
	 * Main
	 * 
	 * @param args
	 * @throws SQLException 
	 */

	public static void main(String[] args) throws SQLException  {
		DatabaseServiceImpl service = new DatabaseServiceImpl();
		service.createConnection();
	}

}
