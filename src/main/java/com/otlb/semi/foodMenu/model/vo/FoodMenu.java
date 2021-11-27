package com.otlb.semi.foodMenu.model.vo;

import java.sql.Date;

public class FoodMenu {

	private Date menu_date;
	private String main;
	private String soup;
	private String side1;
	private String side2;
	private String dessert;

	public FoodMenu() {
		super();
	}

	public FoodMenu(Date menu_date, String main, String soup, String side1, String side2, String dessert) {
		super();
		this.menu_date = menu_date;
		this.main = main;
		this.soup = soup;
		this.side1 = side1;
		this.side2 = side2;
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

	public String getDessert() {
		return dessert;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

	@Override
	public String toString() {
		return "foodMenu [menu_date=" + menu_date + ", main=" + main + ", soup=" + soup + ", side1=" + side1
				+ ", side2=" + side2 + ", dessert=" + dessert + "]";
	}

}
