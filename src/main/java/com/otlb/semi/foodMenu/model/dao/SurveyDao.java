package com.otlb.semi.foodMenu.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.otlb.semi.bulletin.model.dao.BulletinDao;

public class SurveyDao {
	private Properties prop = new Properties();
	
	public SurveyDao() {
		String filepath = BulletinDao.class.getResource("/survey-query.properties").getPath();
		try {
			prop.load(new FileReader(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
