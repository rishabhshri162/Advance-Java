package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
	
		public static void main(String[] args) throws ClassNotFoundException, SQLException {

			// 1. Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Make connection to the database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

			// 3. Create Statement
			Statement stmt = conn.createStatement();

			// 4. Execute Query and get ResultSet
			int i = stmt.executeUpdate("delete from marksheet where rollNo = 17");
			

				System.out.println("Data deleted successfully: " + i);
			

			conn.close();

		}

}
