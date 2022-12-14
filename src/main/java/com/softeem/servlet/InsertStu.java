package com.softeem.servlet;

import com.softeem.pojo.Student;
import com.softeem.service.StudentService;
import com.softeem.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Date;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-07 16:15
 **/
@WebServlet("/insStu")

public class InsertStu extends HttpServlet {
    private StudentService studentService=new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //sname,password,sex,score,phone,birthday,status,cid
        String sname = req.getParameter("sname");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String score =req.getParameter("score");
        String phone = req.getParameter("phone");
        String birthday = req.getParameter("birthday");
        String status = req.getParameter("status");
        String cid = req.getParameter("cid");
//        System.out.println("sname="+sname);
//        System.out.println("password="+password);
//        System.out.println("sex="+sex);
//        System.out.println("score="+score);
//        System.out.println("phone="+phone);
//        System.out.println("birthday="+birthday);
//        System.out.println("status="+status);
//        System.out.println("cid="+cid);

        Student student=new Student();
        student.setSname(sname);
        student.setPassword(password);
        student.setSex(sex);
        student.setScore(Long.parseLong(score));
        student.setPhone(phone);
        student.setBirthday(Date.valueOf(birthday));
        student.setStatus(Long.parseLong(status));
        student.setCid(Long.parseLong(cid));

        boolean res =studentService.addStu(student);
        resp.sendRedirect("/getAllStuPageCon");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}