package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDatabase {

	private static Connection con;

	public static void openConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url  = "jdbc:mysql://localhost:3306/bankaccount";
		con = DriverManager.getConnection(url,"root","root123");
	}

	public static Connection getConnection() {
		return con;
	}

	public static void closeConnection() throws SQLException {
		if(con!=null) {
			con.close();
		}
	}

}
