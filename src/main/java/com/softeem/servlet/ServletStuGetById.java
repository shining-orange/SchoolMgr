package com.softeem.servlet;

import com.softeem.pojo.Student;
import com.softeem.service.StudentService;
import com.softeem.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-07 16:15
 **/
@WebServlet("/getStu")

public class ServletStuGetById extends HttpServlet {
    private StudentService studentService=new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("sno");
        Student student=studentService.getStuByid(id);
        req.setAttribute("student",student);
        req.getRequestDispatcher("/pages/stu/updStu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}