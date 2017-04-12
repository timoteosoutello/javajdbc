package com.github;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		final Logger LOGGER = LogManager.getLogger();
		
		DatabaseServiceImpl service = new DatabaseServiceImpl();
		StringBuilder query = new StringBuilder().append("select * from adm_user");
		ArrayList<HashMap<String,String>> result = service.runQuery(query.toString());
		LOGGER.debug("Checking the values");
		LOGGER.debug(result);	
		LOGGER.debug("Running queries");
		ArrayList<String> queries = new ArrayList<String>();
		StringBuilder queryUpdate1 = new StringBuilder().append("update adm_user set type = 1");
		queries.add(queryUpdate1.toString());
		StringBuilder queryUpdate2 = new StringBuilder().append("update adm_user set type = 2 where name = 'Test'");
		queries.add(queryUpdate2.toString());
		
		StringBuilder queryInsert = new StringBuilder().append("insert into adm_user (id,name,type) values ('").append(UUID.randomUUID().toString()).append("',").append("'insertTest',").append("1)");
		queries.add(queryInsert.toString());
		queries.add(query.toString());
		
		StringBuilder queryDelete = new StringBuilder().append("delete from adm_user where name = 'insertTest'");
		queries.add(queryDelete.toString());
		LOGGER.debug("Run without batch");	
		service.runQueries(queries);
		LOGGER.debug("Run with batch");
		service.runBatchedQueries(queries);
		
		LOGGER.debug("Checking again the values");
		result = service.runQuery(query.toString());
		LOGGER.debug(result);	
	}

}
