package com.demo.servletpath.dbutils.customer.service;

import com.demo.servletpath.dbutils.customer.dao.CustomerDaoImpl;
import com.demo.servletpath.dbutils.customer.domain.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 7 on 2016/12/12.
 */
public class CustomService {
	private CustomerDaoImpl customerDao = new CustomerDaoImpl();

	public List<Customer> showAllCustomer() throws SQLException {
		return customerDao.findAllCustomer();
	}

	public Customer findCustomerById(String id) throws SQLException {
		return customerDao.findCustomerById(id);
	}

	public int delCustomerById(String id) throws SQLException {
		return customerDao.delCustomerById(id);
	}

	public int updateCustomer(Customer customer) throws SQLException {
		return customerDao.updateCustomer(customer);
	}

	public int[] delSelect(String[] id) throws SQLException {
		return customerDao.delSelect(id);
	}
}
