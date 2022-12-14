package com.softeem.servlet;

import com.softeem.pojo.Student;
import com.softeem.service.StudentService;
import com.softeem.service.StudentServiceImpl;
import com.softeem.util.PageBean;

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
@WebServlet("/getAllStu")

public class ServletAllStu extends HttpServlet {
    private StudentService studentService=new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageBean pageBean = new PageBean();//请求中，需要获取当前页
        List<Student> studentList =studentService.getAllStu();
        req.setAttribute("data",studentList);
        req.getRequestDispatcher("/pages/stu/stuInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}