package com.otlb.semi.foodMenu.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FoodMenuDao {
	private Properties prop = new Properties();
	
	public FoodMenuDao() {
		String filepath = FoodMenuDao.class.getResource("/foodMenu-query.properties").getPath();
		try {
			prop.load(new FileReader(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
