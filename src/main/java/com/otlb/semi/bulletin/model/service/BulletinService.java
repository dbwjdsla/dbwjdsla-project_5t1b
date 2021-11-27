package com.otlb.semi.bulletin.model.service;

import static com.otlb.semi.common.JdbcTemplate.*;

import com.otlb.semi.bulletin.model.dao.BulletinDao;

public class BulletinService {

	public static final String hasDeleted = "Y";
	public static final String hasNotDeleted = "N";
	public static final String isReported = "Y";
	public static final String isNotReported = "N";
	
	private BulletinDao bulletinDao = new BulletinDao();
}
