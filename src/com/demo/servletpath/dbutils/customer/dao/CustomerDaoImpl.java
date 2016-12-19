package com.demo.servletpath.dbutils.customer.dao;

import com.demo.servletpath.dbutils.customer.domain.Customer;
import com.demo.servletpath.dbutils.customer.domain.PageBean;
import com.demo.servletpath.dbutils.customer.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by 7 on 2016/12/12.
 */
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public int insertCustomer(Customer c) {
		String sql = "insert into customer values(id,name,gender,birthday,cellphone,email," +
				"preference,type,description) values (?,?,?,?,?,?,?,?,?)";
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		Date date = c.getBirthday();
//		queryRunner.insert(sql,c.getId(),c.getName(),c.getGender(),c.getBirthday(),c.getCellphone(),c.getEmail(),c.getPreference(),c.getType(),c.getDescription())
		return 0;
	}

	@Override
	public List<Customer> findAllCustomer() throws SQLException {
		String sql = "select * from customer";
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		List<Customer> customerList = queryRunner.query(sql, new BeanListHandler<Customer>(Customer.class));
//		System.out.println("CustomerDaoImpl"+customerList);
		return customerList;
	}

	@Override
	public Customer findCustomerById(String id) throws SQLException {
		String sql = "select * from customer where id=?";
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		Customer customer = queryRunner.query(sql, new BeanHandler<>(Customer.class), id);
//		System.out.println("CustomerDaoImpl" + customer);
		return customer;
	}

	@Override
	public int delCustomerById(String id) throws SQLException {
		String sql = "delete from customer where id=?";
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		int res = queryRunner.update(sql, id);
//		System.out.println("CustomerDaoImpl" + res);
		return res;
	}

	@Override
	public int updateCustomer(Customer c) throws SQLException {
		String sql = "update customer set id=?,name=?,gender=?,birthday=?,cellphone=?," +
				"email=?,preference=?,type=?,description=? where id=?";
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		int res = queryRunner.update(sql, c.getId(), c.getName(), c.getGender(),
				c.getBirthday(), c.getCellphone(), c.getEmail(), c.getPreference(),
				c.getType(), c.getDescription(), c.getId());
		return res;
	}

	/**
	 * 删除数组Id
	 *
	 * @param id
	 */
	@Override
	public int[] delSelect(String[] id) throws SQLException {
		String sql = "delete from customer where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		Object[][] ids = new Object[id.length][1];

		for (int i = 0; i < id.length; i++) {
			ids[i][0] = id[i];
		}

		int[] batch = runner.batch(sql, ids);
		return batch;
	}

	@Override
	public List<Customer> simpleSelect(String field, String msg) throws SQLException {
		String sql = "select * from customer where " + field + " like ?";

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		return runner.query(sql, new BeanListHandler<Customer>(Customer.class),
				"%" + msg + "%");

	}

	@Override
	public int addCustomer(Customer c) throws SQLException {
		String sql = "insert into customer values(?,?,?,?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		return runner.update(sql, null, c.getName(), c.getGender(),
				c.getBirthday(), c.getCellphone(), c.getEmail(),
				c.getPreference(), c.getType(), c.getDescription());
	}

	@Override
	public List<Customer> findByPage(int pageNum, int currentPage) throws SQLException {
		String sql = "select * from customer limit ?,?";
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		List<Customer> customerList = queryRunner.query(sql, new BeanListHandler<Customer>(Customer.class),(pageNum-1)*currentPage,currentPage);
//		System.out.println("CustomerDaoImpl"+customerList);
		return customerList;
	}

	public int findAllCount() throws SQLException {
		String sql="select count(*) from customer";
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		long query = (long) queryRunner.query(sql, new ScalarHandler());
		return (int) query;
	}
}
