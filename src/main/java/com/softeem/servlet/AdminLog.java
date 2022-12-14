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
import java.util.Objects;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-12 15:29
 **/
@WebServlet("/adminLog")
public class AdminLog extends HttpServlet {
    AdminService adminService=new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        //用户输入的code
        String code=req.getParameter("code");
        //从session中获取正确的code
        String _code = (String) req.getSession().getAttribute("code");
        boolean codeOk= Objects.equals(code,_code);
        DataModel dataModel=new DataModel();

        Admin admin=new Admin();
        admin.setName(name);
        admin.setPassword(password);

        try {
            if(!codeOk){
                dataModel.setCode(1);
                dataModel.setMsg("验证码错误");
                return;
            }
            Admin logAdmin=adminService.loginAdmin(admin);
            if(logAdmin==null) {
                dataModel.setCode(1);
                dataModel.setMsg("用户名或密码错误");
                return;
            }

            dataModel.setCode(0);
            dataModel.setMsg("登录成功");

            //登录成功将数据放入session中
            req.getSession().setAttribute("logData",logAdmin);
        } finally {
            System.out.println("执行响应结果");
            req.getSession().setAttribute("info",admin);
            resp.setCharacterEncoding("utf-8");
            resp.getWriter().print(JSONObject.toJSON(dataModel));
        }

//        if(logAdmin!=null) {
//            resp.sendRedirect("/getAllStuPageCon");
//        }else {
////            resp.sendRedirect("/pages/admin/log.jsp");
//            resp.setContentType("text/html;charset=utf-8");
//            resp.getWriter().print("<script>alert('用户名或密码错误');location.href='/pages/admin/log.jsp'</script>");
 //       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}