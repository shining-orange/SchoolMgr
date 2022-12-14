package com.softeem.servlet;

import com.softeem.util.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-12 16:06
 **/
@WebServlet("/showCode")
public class ShowCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建验证码对象
        VerifyCode vc=new VerifyCode();
        //获取验证码的图片
        BufferedImage image = vc.createImage();
        //获取验证码的文本(和用户输入的文本进行比较)
        String code = vc.getText();
        //将验证码的文本保存到session中
        req.getSession().setAttribute("code",code);
        //将验证码的图片显示到页面
        vc.output(image,resp.getOutputStream());

    }
}