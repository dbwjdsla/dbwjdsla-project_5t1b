package com.otlb.semi.bulletin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BulletinDao {

	private Properties prop = new Properties();
	
	public BulletinDao() {
		String filepath = BulletinDao.class.getResource("bulletin-query.properties").getPath();
		try {
			prop.load(new FileReader(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
