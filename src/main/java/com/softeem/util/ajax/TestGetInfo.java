package com.softeem.util.ajax;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 创建作者 ：Mr.YJ
 * 创建时间 2022/12/9 15:04
 * 项目名称 Web_Student
 */
@WebServlet("/testGetInfo")
public class TestGetInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("name = " + name);
        String age = req.getParameter("age");
        User user = new User(2,name,20);
//        resp.getWriter().print("ok");
        resp.setCharacterEncoding("utf-8"); //设置响应字符集
//        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().print(JSONObject.toJSON(user)); //将user封装的数据转为json格式字符串，响应前端

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp); //如果前端发送post请求，在实现时，调用具体的实现（doget实现）
    }
}
