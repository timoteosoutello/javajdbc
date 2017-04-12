package com.github.service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Database interface.
 * 
 * @author Timóteo Soutello
 *
 */
public interface DabaseService {

	/**
	 * run single query.
	 * @param query instance.
	 * @return ArrayList<HashMap<String, String>> with the values.
	 */
	ArrayList<HashMap<String, String>> runQuery(String query);

	/**
	 * Run queries.
	 * @param queries instances.
	 */
	void runQueries(ArrayList<String> queries);

}
