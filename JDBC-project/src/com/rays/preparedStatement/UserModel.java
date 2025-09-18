package com.rays.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

	public int nextpk() throws SQLException, ClassNotFoundException {
		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);

		}
		conn.close();
		return pk + 1;
	}
	
	public void add(UserBean bean) throws ClassNotFoundException, SQLException {
		

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?)");
		int pk = nextpk();

	    pstmt.setInt(1, pk);
	    pstmt.setString(2, bean.getFirstname());
	    pstmt.setString(3, bean.getLastname());
	    pstmt.setString(4, bean.getLogin());
	    pstmt.setString(5, bean.getPassword());
	    pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
	    
	    int i = pstmt.executeUpdate();
	    System.out.println("data inserted successfully: " + i);
	    conn.close();
		
		
	}
}
