package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2. Make connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		// 3. Create Statement
		Statement stmt = conn.createStatement();

		// 4. Execute Query and get ResultSet
		int i = stmt.executeUpdate("insert into marksheet values(15,'rahul', 55,65,58)");

//		
		

			System.out.println("Data added successfully: " + i);
		

		conn.close();

	}

}
