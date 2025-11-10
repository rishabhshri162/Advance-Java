package com.rays.preparedStatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {
//		
//		UserModel model = new UserModel();
//		
//		System.out.println(model.nextpk());
//		
//		testAdd();
//		testDelete();
		// testUpdate();
//	 testFindByLogin();
//	testAuthenticate();
		testChangePassword();
//		testSearch();

	}

	// Test add
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

	// test delete

	public static void testDelete() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setId(7);

		model.delete(bean);
		;

	}

	// test update

	public static void testUpdate() throws Exception {
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

	// test find by login

	public static void testFindByLogin() throws Exception {

		UserModel model = new UserModel();

		UserBean existsBean = model.findByLogin("ks@gmail.com");

		if (existsBean != null) {
			System.out.println("login id is already exist");
		} else {
			System.out.println("no record found");
		}

	}

//test authenticate

	public static void testAuthenticate() throws Exception {

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

//test change password

	public static void testChangePassword() throws Exception {
		UserModel model = new UserModel();
		model.changePassword("ms@gmail.com", "sjdwjkdbew", "1234");
	}

	// test Search

	public static void testSearch() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setFirstname("n");
//		bean.setLastname("m");
//		bean.setId(1);
//        bean.setLogin("");
		bean.setDob(sdf.parse("1990-11-25"));
		List list = model.search(bean);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstname());
			System.out.print("\t" + bean.getLastname());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
		}

	}

}
