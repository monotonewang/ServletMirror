package com.demo.servletpath.response;

import com.demo.servletpath.jdbc.dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 7 on 2016/11/28.
 */
@WebServlet(name = "ServletMyInterFace")
public class ServletMyInterFace extends HttpServlet {
    Dao dao = new Dao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username="+username+"password="+password);
        response.getWriter().write("success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String num = request.getParameter("num");//获取请求参数-->多少数据
        int index = Integer.parseInt(num);
        String sql = "select FlowID flowID,Type type,IdCard idCard,ExamStudent examStudent,StudentName studentName,Location location,Gradle gradle from examstudent";
//        List<Student> student = dao.getForList(Student.class, sql);
//        //截取
//        List<Student> students = student.subList(0, index);
//        String str = JSONObject.toJSONString(students);
//        response.getWriter().write(str);
    }
}
