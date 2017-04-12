package com.github;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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

	public static void main(String[] args) throws SQLException {
		DatabaseServiceImpl service = new DatabaseServiceImpl();
		StringBuilder builder = new StringBuilder();
		builder.append("select * from adm_user");
		ArrayList<HashMap<String,String>> result = service.runQuery(builder.toString(), null);
		System.out.println(result);
		// System.out.println(UUID.randomUUID().toString());
	}

}
