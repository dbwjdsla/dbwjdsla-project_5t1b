package com.otlb.semi.message.model.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MessageDao {
	
	private Properties prop = new Properties();
	
	public MessageDao() {
		File file = new File(MessageDao.class.getResource("/message-query.properties").getPath());
		
		try {
			prop.load(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
