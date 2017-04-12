package com.github.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.constants.DatabaseConstants;

/**
 * 
 * Class responsible to be a helper for database functions.
 * 
 * @author Timóteo Soutello
 *
 */
public class DatabaseHelper {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * Getting java.sql.Connection instance
	 * 
	 * @return Connection instance
	 */
	public static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DatabaseConstants.DRIVER.getValue());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DatabaseConstants.URL.getValue(),
					DatabaseConstants.USER.getValue(), DatabaseConstants.PASSWORD.getValue());
			return dbConnection;
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		}
		return dbConnection;
	}

	/**
	 * Get current TimeStamp
	 * 
	 * @return TimeStamp instance.
	 */
	public static java.sql.Timestamp getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	/**
	 * Close ResultSet
	 * 
	 * @param resulSet
	 *            instance
	 */
	public static void closeResultSet(ResultSet resulSet) {
		try {
			if (resulSet != null && !resulSet.isClosed())
				resulSet.close();
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Close Connection
	 * 
	 * @param Connection
	 *            instance
	 */
	public static void closeConnection(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				if (!connection.getAutoCommit()) {
					connection.commit();
				}
				connection.close();
			}

		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Close Statement
	 * 
	 * @param Statement
	 *            instance
	 */
	public static void closeStatement(Statement statement) {
		try {
			if (statement != null && !statement.isClosed())
				statement.close();
		} catch (SQLException e) {
			LOGGER.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Close database instances
	 * 
	 * @param connection
	 *            instance
	 * @param resulSet
	 *            instance
	 * @param Statement
	 *            instance
	 */
	public static void closeDatabaseInstances(Connection connection, ResultSet resulSet, Statement Statement,
			Boolean isTransactional) {
		closeResultSet(resulSet);
		closeStatement(Statement);
		closeConnection(connection);
	}
}
