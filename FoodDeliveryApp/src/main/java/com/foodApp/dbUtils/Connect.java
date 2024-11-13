package com.foodApp.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

final public class Connect {
	private static Connection con=null;
	private static String url="jdbc:mysql://localhost:3306/fooddelivery";
	private static String uname="root";
	private static String pwd="root";
	public static Connection myConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,uname,pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
