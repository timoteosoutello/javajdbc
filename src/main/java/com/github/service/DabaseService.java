package com.github.service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * jReport interface.
 * 
 * @author Timóteo Soutello
 *
 */
public interface DabaseService {
	
	ArrayList<HashMap<String, String>> runQuery(String query, Integer limitSize);

}
