package com.otlb.semi.mainpage.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class FoodMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date menu_date;
	private String main;
	private String soup;
	private String side1;
	private String side2;
	private String side3;
	private String dessert;
	
	
	public FoodMenu() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FoodMenu(Date menu_date, String main, String soup, String side1, String side2, String side3,
			String dessert) {
		super();
		this.menu_date = menu_date;
		this.main = main;
		this.soup = soup;
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.dessert = dessert;
	}


	public Date getMenu_date() {
		return menu_date;
	}


	public void setMenu_date(Date menu_date) {
		this.menu_date = menu_date;
	}


	public String getMain() {
		return main;
	}


	public void setMain(String main) {
		this.main = main;
	}


	public String getSoup() {
		return soup;
	}


	public void setSoup(String soup) {
		this.soup = soup;
	}


	public String getSide1() {
		return side1;
	}


	public void setSide1(String side1) {
		this.side1 = side1;
	}


	public String getSide2() {
		return side2;
	}


	public void setSide2(String side2) {
		this.side2 = side2;
	}


	public String getSide3() {
		return side3;
	}


	public void setSide3(String side3) {
		this.side3 = side3;
	}


	public String getDessert() {
		return dessert;
	}


	public void setDessert(String dessert) {
		this.dessert = dessert;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "FoodMenuVo [menu_date=" + menu_date + ", main=" + main + ", soup=" + soup + ", side1=" + side1
				+ ", side2=" + side2 + ", side3=" + side3 + ", dessert=" + dessert + "]";
	}
	
	
	

}
