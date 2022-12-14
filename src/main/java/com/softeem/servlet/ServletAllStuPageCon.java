package com.softeem.servlet;

import com.softeem.pojo.Clazz;
import com.softeem.pojo.Student;
import com.softeem.service.ClazzService;
import com.softeem.service.ClazzServiceImpl;
import com.softeem.service.StudentService;
import com.softeem.service.StudentServiceImpl;
import com.softeem.util.PageBean;

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
 * @create: 2022-12-07 16:15
 **/
@WebServlet("/getAllStuPageCon")

public class ServletAllStuPageCon extends HttpServlet {
    private StudentService studentService=new StudentServiceImpl();
    ClazzService clazzService=new ClazzServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageBean pageBean = new PageBean();//请求中，需要获取当前页
        String pageNum = req.getParameter("pageNum");
        if (pageNum==null||pageNum.equals("")){ //首次访问数据，没有传递页码，参数值为null
            pageNum = "1";
        }
        pageBean.setPageNum(Integer.parseInt(pageNum));
        String sname =req.getParameter("sname");
        String scoreFrom =req.getParameter("scoreFrom");
        String scoreTo= req.getParameter("scoreTo");
        String cid =req.getParameter("cid");
        String birthFrom=req.getParameter("birthFrom");
        String birthTo =req.getParameter("birthTo");

        pageBean.setSname(sname);
        pageBean.setScoreFrom(scoreFrom);
        pageBean.setScoreTo(scoreTo);
        pageBean.setCid(cid);
        pageBean.setBirthFrom(birthFrom);
        pageBean.setBirthTo(birthTo);

        System.out.println("pageBean = " + pageBean);

        List<Student> studentList = studentService.getAllStu(pageBean);
        List<Clazz> clazzList=clazzService.allClazz();
        req.setAttribute("dataClazz",clazzList);//数据源放到请区域
        req.setAttribute("data",studentList);//数据源放到请区域
        req.setAttribute("pageBean",pageBean);//将分页数据放到请区域
        req.getRequestDispatcher("/pages/stu/stuInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}