package com.github.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.helper.DatabaseHelper;
import com.github.service.DabaseService;

public class DatabaseServiceImpl implements DabaseService {

	private static final Logger LOGGER = LogManager.getLogger();

	public ArrayList<HashMap<String, String>> runQuery(String query) {
		/* Instantiate database objects */
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		try {
			// Get connection from DB service
			connection = DatabaseHelper.getDBConnection();
			// Get DB schema name of tenant
			statement = connection.createStatement();
			LOGGER.debug("Running "+ query.toString());
			resultSet = statement.executeQuery(query);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			// Get Data
			while (resultSet.next()) {
				HashMap<String, String> map = new HashMap<String, String>();
				for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
					map.put(resultSetMetaData.getColumnLabel(i), resultSet.getObject(i).toString());
				}
				result.add(map);
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			LOGGER.error(e.getLocalizedMessage());
		} finally {
			DatabaseHelper.closeDatabaseInstances(connection, resultSet, statement, false);
		}
		return result;
	}

	public void runQueries(ArrayList<String> queries) {
		/* Instantiate database objects */
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			connection = DatabaseHelper.getDBConnection();
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			for (Iterator<String> iterator = queries.iterator(); iterator.hasNext();) {
				String query = (String) iterator.next();
				statement.executeUpdate(query);
				LOGGER.debug("Running "+ query.toString());
			}
			connection.commit();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			LOGGER.error(e.getLocalizedMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println(e.getLocalizedMessage());
				LOGGER.error(e.getLocalizedMessage());
			}
		} finally {
			DatabaseHelper.closeDatabaseInstances(connection, resultSet, statement, false);
		}
	}
}
