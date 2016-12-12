package com.demo.servletpath.jdbc.transaction;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc中事务操作介绍
 * Created by WangTest on 2016/12/10.
 */
public class TransactionTest1 {
    //mysql autocommit 的默认值是true;
    @Test
    public void TranTest1() {
        String sql = "update dept set sal =5000 where did=1";
        Connection connectionByRes = null;
        Statement statement = null;
        try {
            connectionByRes = JdbcUtils.getConnectionByRes();
            statement = connectionByRes.createStatement();
            statement.executeUpdate(sql);
            //设置是否自动提交事务
            //connectionByRes.setAutoCommit(false);
            //提交事务
            connectionByRes.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //如果发生了异常...回滚事务
            try {
                connectionByRes.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            JdbcUtils.release(null, statement, connectionByRes);
        }
    }
}
