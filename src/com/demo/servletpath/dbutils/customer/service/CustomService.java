package com.demo.servletpath.dbutils.customer.service;

import com.demo.servletpath.dbutils.customer.dao.CustomerDaoImpl;
import com.demo.servletpath.dbutils.customer.domain.Customer;
import com.demo.servletpath.dbutils.customer.domain.PageBean;

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

    public List<Customer> simpleSelect(String field, String msg) throws SQLException {
        return customerDao.simpleSelect(field, msg);
    }

    public int addCustomer(Customer customer) throws SQLException {
        return customerDao.addCustomer(customer);
    }

    /**
     * 分页操作
     *
     * @param pageNum     页码
     * @param currentPage 每页显示条数
     */
    public PageBean findByPage(int pageNum, int currentPage) throws SQLException {
        PageBean pageBean = new PageBean();
        List<Customer> customerList = customerDao.findByPage(pageNum, currentPage);

        //查询总条数
        int totalCount = customerDao.findAllCount();
//        System.out.print("totalCount="+totalCount);
        //得到总页数
        int totalPage = (int) ((totalCount * 1.0) / currentPage+1);
//        System.out.print("totalPage="+totalPage);
        pageBean.setCustomerList(customerList);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageNum(pageNum);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}
