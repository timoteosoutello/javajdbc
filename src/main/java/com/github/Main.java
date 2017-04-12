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
		StringBuilder query = new StringBuilder().append("select * from adm_user");
		ArrayList<HashMap<String,String>> result = service.runQuery(query.toString());
		System.out.println(result);
		
		ArrayList<String> queries = new ArrayList<String>();
		StringBuilder queryUpdate1 = new StringBuilder().append("update adm_user set type = 1");
		queries.add(queryUpdate1.toString());
		StringBuilder queryUpdate2 = new StringBuilder().append("update adm_user set type = 2 where name = 'Test'");
		queries.add(queryUpdate2.toString());
		service.runQueries(queries);
		
		result = service.runQuery(query.toString());
		System.out.println(result);	
	}

}
