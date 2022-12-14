package com.softeem.servlet;


import com.alibaba.fastjson.JSONObject;
import com.softeem.pojo.Admin;
import com.softeem.service.AdminService;
import com.softeem.service.AdminServiceImpl;
import com.softeem.util.DataModel;
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
 * @create: 2022-12-12 10:00
 **/
@WebServlet("/checkAcc")
public class CheckAcc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Admin admin = new Admin();
        admin.setName(name);
        //调用service
        AdminService adminService = new AdminServiceImpl();
        Admin acc = adminService.checkAccount(name);
        DataModel model = new DataModel();
        if (acc==null){ //可以注册
            model.setCode(0);
            model.setMsg("账号可用");
            model.setData(admin);
            model.setCounts(1000);
            //调用service注册的方法
        }else {
            model.setCode(1);
            model.setMsg("账号不可用");
        }
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(JSONObject.toJSON(model));


    }
}