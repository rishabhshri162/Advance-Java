package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.rays.bean.CustomerBean;
import com.rays.util.JDBCDataSource;

public class CustomerModel {

	// add method

	public int nextPk() throws Exception {

		Connection conn = null;

		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_customer");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);

			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.getMessage();

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return pk + 1;

	}

	public int add(CustomerBean bean) throws Exception {
		Connection conn = null;
		int pk = 0;

		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into st_customer values(?, ?, ?, ?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getCustomerName());
			pstmt.setString(3, bean.getCustomerEmail());
			pstmt.setString(4, bean.getCustomerPhone());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (Exception ex) {
				e.getMessage();
			}
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;

	}

	public void update(CustomerBean bean) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update st_customer set customerName = ?, customerEmail = ?, customerPhone = ?  where id = ?");
			pstmt.setString(1, bean.getCustomerName());
			pstmt.setString(2, bean.getCustomerEmail());
			pstmt.setString(3, bean.getCustomerPhone());
			pstmt.setInt(4, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (Exception ex) {
				e.getMessage();
			}
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	public CustomerBean findByPk(int pk) throws Exception {

		CustomerBean bean = new CustomerBean();
		Connection conn = null;

		StringBuffer sb = new StringBuffer("select * from st_customer where id = ?");

		try {

			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new CustomerBean();
				bean.setId(rs.getInt(1));
				bean.setCustomerName(rs.getString(2));
				bean.setCustomerEmail(rs.getString(3));
				bean.setCustomerPhone(rs.getString(4));

			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (Exception ex) {
				e.getMessage();
			}
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;

	}

	public void Delete(CustomerBean bean) throws Exception {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from st_customer where id = ?");
			pstmt.setInt(1, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (Exception ex) {
				e.getMessage();
			}
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	public CustomerBean findByEmailId(String customerEmail) throws Exception {

		StringBuffer sql = new StringBuffer("select * from st_customer where CustomerEmail = ?");
		CustomerBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, customerEmail);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new CustomerBean();
				bean.setId(rs.getInt(1));
				bean.setCustomerName(rs.getString(2));
				bean.setCustomerEmail(rs.getString(3));
				bean.setCustomerPhone(rs.getString(4));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}

	public List<CustomerBean> list() throws Exception {
		return search(null, 0, 0);
	}

	// search method

	public List<CustomerBean> search(CustomerBean bean, int pageNo, int pageSize) throws Exception {

		StringBuffer sql = new StringBuffer("select * from st_customer where 1 = 1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getCustomerName() != null && bean.getCustomerName().length() > 0) {
				sql.append(" and CustomerName like '" + bean.getCustomerName() + "%'");
			}

			if (bean.getCustomerEmail() != null && bean.getCustomerEmail().length() > 0) {
				sql.append(" and CustomerEmail like '" + bean.getCustomerEmail() + "%'");
			}
			if (bean.getCustomerPhone() != null && bean.getCustomerPhone().length() > 0) {
				sql.append(" and CustomerPhone like '" + bean.getCustomerPhone() + "%'");
			}

		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new CustomerBean();
				bean.setId(rs.getInt(1));
				bean.setCustomerName(rs.getString(2));
				bean.setCustomerEmail(rs.getString(3));
				bean.setCustomerPhone(rs.getString(4));
				list.add(bean);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return list;
	}

}
