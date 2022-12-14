package com.softeem.servlet;

import com.softeem.pojo.Clazz;
import com.softeem.service.ClazzService;
import com.softeem.service.ClazzServiceImpl;

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
 * @create: 2022-12-09 11:16
 **/
@WebServlet("/addStuWithClazz")
public class addStuWithClazz extends HttpServlet{
    ClazzService clazzService=new ClazzServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Clazz> clazzList=clazzService.allClazz();
        req.setAttribute("dataClazz",clazzList);
        //跳转添加页面
        req.getRequestDispatcher("/pages/stu/addStu.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}