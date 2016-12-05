package com.demo.servletpath.jdbcold;


import com.demo.servletpath.jdbcold.bean.Student;
import com.demo.servletpath.jdbcold.bean.User;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcTest {
    @Test
    public void testQueryPreparedStatement() {
        Connection connection = null;
        //有限的防止sql注入
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcTools.getConnection();
            String sql = "select * from user";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setBrith((Date) resultSet.getObject(5));
                System.out.println(user);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JdbcTools.release(resultSet, preparedStatement, connection);
        }
    }

    /**
     * 添加数据
     */
    @Test
    public void testPreparedStatement() {
        Connection connection = null;
        //有限的防止sql注入
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcTools.getConnection();
            String sql = "insert into examstudent (FlowId,Type,IDCard,ExamStudent,StudentName,Location,Gradle) values(?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < 80; i++) {
                Student student = new Student();
                student.setFlowID(1 + i);
                student.setType(4 + i);
                student.setIdCard("5" + i);
                student.setExamStudent("21212" + i);
                student.setStudentName("张山" + i);
                student.setLocation("北京" + i);
                student.setGradle(2 + i);


                preparedStatement.setInt(1, student.getFlowID());
                preparedStatement.setInt(2, student.getType());
                preparedStatement.setString(3, student.getIdCard());
                preparedStatement.setString(4, student.getExamStudent());
                preparedStatement.setString(5, student.getStudentName());
                preparedStatement.setString(6, student.getLocation());
                preparedStatement.setInt(7, student.getGradle());
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JdbcTools.release(null, preparedStatement, connection);
        }

    }

    /**
     * 添加新的学生
     */
    @Test
    public void addNewStudent() {
        Student student = new Student();
        student.setFlowID(1);
        student.setType(4);
        student.setIdCard("1212121");
        student.setExamStudent("2005020202");
        student.setStudentName("21212");
        student.setLocation("212125555");
        student.setGradle(1);
        String sql = "insert into examstudent values (" + student.getFlowID() + "," + student.getType() + "," + student.getIdCard() + "," + student.getExamStudent() + "," + student.getStudentName() + "," + student.getLocation() + "," + student.getGradle() + ")";
        insert(sql);
    }

    /**
     * 得到学生对象
     */
    @Test
    public void selectStudent() {
        Connection connection = null;
        Statement stat = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcTools.getConnection();
            stat = connection.createStatement();
            String sql = "select * from examstudent";
            resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student();
                student.setFlowID(resultSet.getInt(1));
                student.setType(resultSet.getInt(2));
                student.setIdCard(resultSet.getString(3));
                student.setExamStudent(resultSet.getString(4));
                student.setStudentName(resultSet.getString(5));
                student.setLocation(resultSet.getString(6));
                student.setGradle(resultSet.getInt(7));
//				ResultSetMetaData metaData=resultSet.getMetaData();
//				String str=metaData.getColumnLabel(1);
//				System.out.println(str);
                System.out.println(student);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JdbcTools.release(null, stat, connection);

    }

    /**
     * 查询sql的方法
     *
     * @param sql
     */
    public void insert(String sql) {
        Connection connection = null;
        Statement stat = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcTools.getConnection();
            stat = connection.createStatement();

            stat.execute(sql);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JdbcTools.release(null, stat, connection);
    }


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
            connection = JdbcTools.getConnection();
            // 2.调用Connection获取Statement对象
            stat = connection.createStatement();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 3.准备sql语句
        String sql = "select * from examstudent";
        // 4.发送sql语句获得ResultSet对象
        try {
            resultSet = stat.executeQuery(sql);
            // 5.1处理及国际。调用next()方法。
            while (resultSet.next()) {
                String name = resultSet.getString(4);
                System.out.println(name);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 5.2getXxx()方法获取值、
    }

    /**
     * 获取连接的方法
     *
     * @throws Exception
     */
    @Test
    public void testConnection() throws Exception {
//		Driver driver=new Driver();


//		String url="jdbcold:mysql://127.0.0.1:3306/goods";
//		Properties info =new Properties();
//		info.put("user","root");
//		info.put("password", "root");
//		Connection connection=(Connection) driver.connect(url, info);
        Connection con = getConnection();
        Statement stat = con.createStatement();
        System.out.println(con);
    }

    /**
     * 得到连接的方法
     *
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        String driverClass = null;
        String jdbcUrl = null;
        String user = null;
        String password = null;

        Properties pro = new Properties();
        InputStream in = getClass().getClassLoader().getResourceAsStream("com/demo/servletpath/jdbc.properties");
        pro.load(in);
//		driverClass=pro.getProperty("driver");
        jdbcUrl = pro.getProperty("jdbcUrl");
        user = pro.getProperty("user");
        password = pro.getProperty("password");

//		Driver driver=(Driver)Class.forName(driverClass).newInstance();
        Properties info = new Properties();
        info.put("user", user);
        info.put("password", password);
//		DriverManager.deregisterDriver(driver);
        Connection con = DriverManager.getConnection(jdbcUrl, info);
//		 driver.connect(jdbcUrl, info);
        return con;
    }


}
