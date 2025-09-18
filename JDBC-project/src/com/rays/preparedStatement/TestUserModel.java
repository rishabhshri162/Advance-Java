package com.rays.preparedStatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestUserModel {
	
	public static void main(String[] args) throws Exception {
//		
//		UserModel model = new UserModel();
//		
//		System.out.println(model.nextpk());
		testAdd();
		
	}
	public static void testAdd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setFirstname("Parth");
		bean.setLastname("Nema");
		bean.setLogin("pn@gmail.com");
		bean.setPassword("ldsjskldggdf");
		bean.setDob(sdf.parse("2002-11-25"));
		
		
		model.add(bean);
	}

}
