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
//		
//		testAdd();
//		testDelete();
	    //testUpdate();
		testFindByLogin();
//		testAuthenticate();
	}
	
	//Test add 
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
	
	//test delete
	
	public static void testDelete() throws ClassNotFoundException, SQLException {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setId(7);
		
		model.delete(bean);;
		
	}
	
	//test update
	
	public static void testUpdate() throws ClassNotFoundException, SQLException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
		bean.setId(1);
		bean.setFirstname("Mridul");
		bean.setLastname("Sharma");
		bean.setLogin("ms@gmail.com");
		bean.setPassword("sjdwjkdbew");
		bean.setDob(sdf.parse("2001-11-06"));
	
		model.update(bean);
		
		
		
	}
	
	
	//test find by login
	
public static void testFindByLogin() throws Exception {
		
		UserModel model = new UserModel();
		
		UserBean existsBean = model.findByLogin("ks@gmail.com");
		
		if(existsBean != null) {
			System.out.println("login id is already exist");
		} else {
			System.out.println("no record found");
		}

}

//test authenticate


private static void testAuthenticate() throws Exception {

	UserModel model = new UserModel();

	UserBean bean = model.authenticate("ms@gmail.com", "sjdwjkdbew");

	if (bean != null) {
		System.out.println("User found:");
		System.out.println(bean.getFirstname());
		System.out.println(bean.getLastname());
	} else {
		System.out.println("user not found");
	}

}
}
