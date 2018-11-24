package com.yc.dao.copy;

public class Test {
	public static void main(String[] args) {
		DBHelper dbHelper=new DBHelper();
		System.out.println(dbHelper.find("select * from columns", null) );

	}
	
}
