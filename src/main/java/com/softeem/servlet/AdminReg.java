package com.softeem.servlet;

import com.alibaba.fastjson.JSONObject;
import com.softeem.pojo.Admin;
import com.softeem.service.AdminService;
import com.softeem.service.AdminServiceImpl;
import com.softeem.util.DataModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-09 16:44
 **/
@WebServlet("/adminReg")
@MultipartConfig
public class AdminReg extends HttpServlet {
    //调用service
    AdminService adminService = new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Part part =req.getPart("head");
//        System.out.println(part.getSubmittedFileName());
        String fileName = part.getSubmittedFileName();

        //封装到admin
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPassword(password);
        admin.setHeadimg(fileName);
        //调用service注册
        int i = adminService.regAdmin(admin);
//        Admin admin = new Admin();
//        admin.setName(name);
//        admin.setPassword(password);
//
//        Admin acc = adminService.checkAccount(name);
//       /* if (acc==null){
//            int i = adminService.regAdmin(admin);//添加到数据库之前，应该判断用户名是否存在
//            if (i>0){  //注册成功，跳转到登录页面
//                resp.sendRedirect("/pages/admin/log.jsp");
//            }
//        }else {
//            resp.sendRedirect("/pages/admin/reg.jsp");
//        }*/
//        DataModel model = new DataModel();
//        if (acc==null){ //可以注册
//            model.setCode(0);
//            model.setMsg("账号可用");
//            model.setData(admin);
//            model.setCounts(1000);
//        }else {
//            model.setCode(1);
//            model.setMsg("账号不可用");
//        }
//        resp.setCharacterEncoding("utf-8");
//        resp.getWriter().print(JSONObject.toJSON(model));
//
//
//    }
        String url = "";
        String msg = "";
        if (i>0){ //注册成功，跳转到登录页面
            url = "/pages/admin/log.jsp";
            msg = "注册成功";
            //将用户信息保存到session中 ，无论是转发还是重定向，都可以在页面或请求中共享
            req.getSession().setAttribute("adminData",admin);
        }else {  //注册失败，回到注册页面
            url = "/pages/admin/reg.jsp";
            msg = "注册失败";
        }
        //将用户头像上传到当前项目的images目录下
        String path = "E:\\idea\\yj\\SchoolMgr\\src\\main\\webapp\\pages\\images\\";
        part.write(path + fileName);//将头像图片上传到设置的目录
        //resp.sendRedirect(url);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print("<script>alert('"+msg+"');location.href='"+url+"'</script>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
