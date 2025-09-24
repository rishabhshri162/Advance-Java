package com.rays.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransactionHandling {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		conn.setAutoCommit(false);
	

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into employee values(17, 'sunaina', 'Ibm', 100000, 1)");
		i = stmt.executeUpdate("insert into employee values(17, 'Amit', 'ibm', 100000, 2)");
			i = stmt.executeUpdate("insert into employee values(18, 'tarun', 'wipro', 100000, 1)");

			conn.commit();
			System.out.println("transaction is commited;");

		} catch (Exception e) {
			System.out.println("transaction is rolled back");
			conn.rollback();
		}

	}

}