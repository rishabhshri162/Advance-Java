package com.rays.testModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rays.bean.CustomerBean;
import com.rays.model.CustomerModel;

public class TestCustomerModel {
	public static void main(String[] args) throws Exception {

//		CustomerModel model = new CustomerModel();
//		System.out.println(model.nextPk());
//		testAdd();
//		testUpdate();
//		testFindByPk();
//		testDelete();
//		testFindByEmail();
		testSearch();

	}

	public static void testAdd() {

		CustomerBean bean = new CustomerBean();

		bean.setId(1);
		bean.setCustomerName("Rishabh");
		bean.setCustomerEmail("rs@gmail.com");
		bean.setCustomerPhone("9898989898");

		CustomerModel model = new CustomerModel();
		try {
			model.add(bean);
			System.out.println("Data added successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void testUpdate() {
		CustomerBean bean = new CustomerBean();
		bean.setCustomerName("Ram");
		bean.setCustomerEmail("rs@gmail.com");
		bean.setCustomerPhone("9898989898");
		bean.setId(1);

		CustomerModel model = new CustomerModel();
		try {
			model.update(bean);
			System.out.println("Data updated successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testFindByPk() {

		CustomerModel model = new CustomerModel();

		try {
			CustomerBean bean = model.findByPk(1);
			System.out.println(bean.getCustomerEmail());
			System.out.println(bean.getCustomerPhone());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testDelete() {
		CustomerBean bean = new CustomerBean();
		bean.setId(2);
		CustomerModel model = new CustomerModel();
		try {
			model.Delete(bean);
			System.out.println("Customer deleted successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testFindByEmail() {

		CustomerModel model = new CustomerModel();

		try {
			CustomerBean bean = model.findByEmailId("rs@gmail.com");
	
			System.out.println(bean.getCustomerPhone());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void testSearch() {
		try {
			CustomerModel model = new CustomerModel();
			CustomerBean bean = new CustomerBean();
			List list = new ArrayList();
			bean.setCustomerName("Ram");
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (CustomerBean) it.next();
				System.out.println(bean.getCustomerEmail());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
