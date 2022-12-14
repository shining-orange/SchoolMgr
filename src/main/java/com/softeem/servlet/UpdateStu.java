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
import java.sql.Date;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-07 16:15
 **/
@WebServlet("/updStu")

public class UpdateStu extends HttpServlet {
    private StudentService studentService=new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno = req.getParameter("sno");
        String sname = req.getParameter("sname");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String score =req.getParameter("score");
        String phone = req.getParameter("phone");
        String birthday = req.getParameter("birthday");
        String status = req.getParameter("status");
        String cid = req.getParameter("cid");
        //调用service
        //Long.parseLong(sno),sname,password,sex,score,phone,Date.valueOf(birthday),Long.parseLong(status),Long.parseLong(cid)
        Student student=new Student();
        student.setSno(Long.parseLong(sno));
        student.setSname(sname);
        student.setPassword(password);
        student.setSex(sex);
        student.setScore(Long.parseLong(score));
        student.setPhone(phone);
        student.setBirthday(Date.valueOf(birthday));
        student.setStatus(Long.parseLong(status));
        student.setCid(Long.parseLong(cid));
        boolean res=studentService.updStu(student);
        resp.sendRedirect("getAllStuPage");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}