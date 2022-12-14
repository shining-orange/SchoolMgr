package com.softeem.servlet;

import com.softeem.service.StudentService;
import com.softeem.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-07 16:15
 **/

@WebServlet("/delStu")
public class DeleteStu extends HttpServlet {
    private StudentService studentService=new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("sno");
        System.out.println("学号为:"+id);
        boolean res=studentService.delStuById(id);
        System.out.println("res:"+res);
        if (res) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().print("<script>alert('OKOKOK');location.href='/getAllStuPageCon'</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}