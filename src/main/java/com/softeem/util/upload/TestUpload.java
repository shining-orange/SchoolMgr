package com.softeem.util.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-12 10:32
 **/
//@WebServlet("testUpload")
@MultipartConfig //支持文件上传的注解
public class TestUpload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("测试文件上传");
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("usrname");
        System.out.println(username);
//      String myHead=req.getParameter("myHead"); //文件数据不是paramter.是part
        Part part=req.getPart("myHead");//获取文件对象
        System.out.println(part.getSubmittedFileName());//图片名称
        //文件上传的位置
        String path="D:\\myHead";//设置文件上传路径.注意：路径必须存在
        //执行上传文件
        part.write(path+ File.separator+part.getSubmittedFileName());
    }
}