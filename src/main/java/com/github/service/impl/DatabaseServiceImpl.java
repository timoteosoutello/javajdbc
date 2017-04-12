package com.github.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.service.DabaseService;

public class DatabaseServiceImpl implements DabaseService {
	/* Instantiate DB objects */
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	ResultSetMetaData resultSetMetaData = null;

	public void createConnection() throws SQLException {
		try {
			/* Get connection from DB service */
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/postgres";
			Connection conn = DriverManager.getConnection(url, "postgres", "system");
			/* Get DB schema name of tenant */
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from teste");
			/* Column information is required for creating response */
			resultSetMetaData = resultSet.getMetaData();
			/* Iterate over records */
			while (resultSet.next()) {
				System.out.println((String) resultSet.getString("name") + " - " + (Integer) resultSet.getInt("id"));
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			/* Close DB connection/statement/resultSet */
			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}

			if (resultSet != null) {
				resultSet.close();
			}
		}
	}
}
