package com.demo.servletpath.response;

import com.alibaba.fastjson.JSONObject;
import com.demo.jdbc.bean.Student;
import com.demo.jdbc.dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 7 on 2016/11/28.
 */
@WebServlet(name = "ServletMyFirstInterFace")
public class ServletMyFirstInterFace extends HttpServlet {
    Dao dao = new Dao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String sql = "select FlowID flowID,Type type,IdCard idCard,ExamStudent examStudent,StudentName studentName,Location location,Gradle gradle from examstudent";
        List<Student> student = dao.getForList(Student.class, sql);
        //截取
        List<Student> students = student.subList(0, 3);
        String str = JSONObject.toJSONString(students);
        response.getWriter().write(str);
    }
}
