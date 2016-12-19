package com.demo.servletpath.dbutils.customer.dao;

import com.demo.servletpath.dbutils.customer.domain.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 7 on 2016/12/12.
 */
public interface CustomerDao {
	int insertCustomer(Customer customer);

	//查询多个用户
	List<Customer> findAllCustomer() throws SQLException;

	//查询单个用户
	Customer findCustomerById(String id) throws SQLException;

	//删除当个用户
	int delCustomerById(String id) throws SQLException;

	//更新用户
	int updateCustomer(Customer customer) throws SQLException;

	int[] delSelect(String[] id) throws SQLException;
}
