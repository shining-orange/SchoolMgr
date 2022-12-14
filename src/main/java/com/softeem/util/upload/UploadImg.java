package com.softeem.util.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-12 10:47
 **/
@WebServlet("/uploadImg")
@MultipartConfig //支持文件上传的注解
public class UploadImg extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取数据
        String username = req.getParameter("username");
        System.out.println("username = " + username);

        Part part = req.getPart("myHead");
        String fileName = part.getSubmittedFileName();
        System.out.println("fileName = " + fileName);
        //防止多次上传时，提交重复的名称图片
        //思路：更新文件的名称。实现防止重名的方法：1，现有的名称前或后追加字符串或随机数
        //   2 获取当前的时间毫秒数作为图片名称
        //   3 UUID工具类，生成不重复的名称
        String name = UUID.randomUUID().toString();
        System.out.println("name = " + name);
        //替换 字符串的拆分和拼接
        fileName = name + fileName.substring(fileName.lastIndexOf(".")); //uuid字符串+文件后缀
        System.out.println("fileName = " + fileName);
        //上传
        String path = "d:\\myHead\\";
        path = "E:\\idea\\yj\\SchoolMgr\\src\\main\\webapp\\pages\\images\\";
        part.write(path + fileName);
    }
}