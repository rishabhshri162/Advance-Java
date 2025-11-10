package com.rays.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class orderinsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2. Make connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		// 3. Create Statement
		Statement stmt = conn.createStatement();

		// 4. Execute Query and get ResultSet
		int i = stmt.executeUpdate("insert into st_order values(7,'Refrigerator','Noida',25000,'2025-09-22')");

//			

		System.out.println("Data added successfully: " + i);

		conn.close();

	}

}
