package com.demo.servletpath.jdbc.dao;


import com.demo.servletpath.jdbc.utils.JdbcUtils;
import com.demo.servletpath.jdbc.bean.User;
import org.junit.Test;

import java.sql.*;

public class JdbcTest {
    @Test
    public void testQueryPreparedStatement() {
        Connection connection = null;
        //有限的防止sql注入
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnectionByRes();
            String sql = "select * from user";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
//                user.setBrith((Date) resultSet.getObject(5));
                System.out.println(user);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JdbcUtils.release(resultSet, preparedStatement, connection);
        }
    }

//    /**
//     * 添加数据
//     */
//    @Test
//    public void testPreparedStatement() {
//        Connection connection = null;
//        //有限的防止sql注入
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = JdbcUtils.getConnectionByRes();
//            String sql = "insert into examstudent (FlowId,Type,IDCard,ExamStudent,StudentName,Location,Gradle) values(?,?,?,?,?,?,?)";
//            preparedStatement = connection.prepareStatement(sql);
//
//            for (int i = 0; i < 80; i++) {
//                Student student = new Student();
//                student.setFlowID(1 + i);
//                student.setType(4 + i);
//                student.setIdCard("5" + i);
//                student.setExamStudent("21212" + i);
//                student.setStudentName("张山" + i);
//                student.setLocation("北京" + i);
//                student.setGradle(2 + i);
//
//
//                preparedStatement.setInt(1, student.getFlowID());
//                preparedStatement.setInt(2, student.getType());
//                preparedStatement.setString(3, student.getIdCard());
//                preparedStatement.setString(4, student.getExamStudent());
//                preparedStatement.setString(5, student.getStudentName());
//                preparedStatement.setString(6, student.getLocation());
//                preparedStatement.setInt(7, student.getGradle());
//                preparedStatement.executeUpdate();
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            JdbcUtils.release(null, preparedStatement, connection);
//        }
//
//    }
//

//
//    /**
//     * 得到学生对象
//     */
//    @Test
//    public void selectStudent() {
//        Connection connection = null;
//        Statement stat = null;
//        ResultSet resultSet = null;
//        try {
//            connection = JdbcUtils.getConnectionByRes();
//            stat = connection.createStatement();
//            String sql = "select * from examstudent";
//            resultSet = stat.executeQuery(sql);
//            while (resultSet.next()) {
//                Student student = new Student();
//                student.setFlowID(resultSet.getInt(1));
//                student.setType(resultSet.getInt(2));
//                student.setIdCard(resultSet.getString(3));
//                student.setExamStudent(resultSet.getString(4));
//                student.setStudentName(resultSet.getString(5));
//                student.setLocation(resultSet.getString(6));
//                student.setGradle(resultSet.getInt(7));
////				ResultSetMetaData metaData=resultSet.getMetaData();
////				String str=metaData.getColumnLabel(1);
////				System.out.println(str);
//                System.out.println(student);
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        JdbcUtils.release(resultSet, null, connection);
//
//    }



    /**
     * 查询单个结果的处理
     */
    @Test
    public void testResultSet() {
        Connection connection = null;
        Statement stat = null;
        ResultSet resultSet = null;
        // 1.获取数据库连接
        try {
            connection = JdbcUtils.getConnectionByRes();
            // 2.调用Connection获取Statement对象
            stat = connection.createStatement();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 3.准备sql语句
        String sql = "select * from dept";
        // 4.发送sql语句获得ResultSet对象
        try {
            resultSet = stat.executeQuery(sql);
            // 5.1处理结果集。调用next()方法。
            while (resultSet.next()) {
                String name = resultSet.getString(3);
                System.out.println(name);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 5.2getXxx()方法获取值、
    }


}
