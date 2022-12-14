package com.softeem.service;

import com.softeem.dao.StudentDao;
import com.softeem.dao.StudentDaoImpl;
import com.softeem.pojo.Student;
import com.softeem.util.DruidConn;
import com.softeem.util.PageBean;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-07 16:14
 **/

public class StudentServiceImpl implements StudentService{

    StudentDao studentDao=new StudentDaoImpl();
    @Override
    public List<Student> getAllStu() {

        List<Student> studentList =null;
        try {
            studentList=studentDao.getAllStu();
        } catch (SQLException e) {
            System.out.println("调用service执行的时候报错拉！！！");
            throw new RuntimeException(e);
        }finally {

            //释放资源
            DruidConn.close(DruidConn.getConn(),null,null);
        }
        return studentList;
    }

    @Override
    public boolean delStuById(String id) {
        boolean res=false;
        try {
            res= studentDao.delStuById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            //释放资源
            DruidConn.close(DruidConn.getConn(),null,null);
        }
        return res;
    }

    @Override
    public boolean updStu(Student student) {
        boolean res=false;
        try {
            res= studentDao.updStu(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //释放资源
            DruidConn.close(DruidConn.getConn(),null,null);
        }
        return res;
    }

    @Override
    public boolean addStu(Student student) {
        boolean res=false;
        try {
            res=studentDao.addStu(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            //释放资源
            DruidConn.close(DruidConn.getConn(),null,null);
        }
        return res;
    }

    @Override
    public Student getStuByid(String id) {
        Student student=new Student();
        try {
            student=studentDao.getStuByid(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            //释放资源
            DruidConn.close(DruidConn.getConn(),null,null);
        }
        return student;
    }

    @Override
    public List<Student> getAllStu(PageBean pageBean){
        //业务逻辑：执行数据库操作前，准备完毕所有的参数（当前页，每页条数，总页数，总条数）。
        //       每页条数已经有(默认为3)，当前页（从页面请求时获取-servlet）
        //       总页数：依据总条数与每页条数相除即可得到
        //       总条数：查询数据库表格（统计sql的聚合函数count(*) ）

        long total = 0;    //总条数（学生总人数）
        try {
            total = studentDao.getAllCount(pageBean);  //条件查询后，限制对应的结果数量
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int _total = (int)total;
        //计算总页数  根据：总条数  和 每页条数  相除
        int totalPages = _total % pageBean.getPageSize() == 0  ?  _total / pageBean.getPageSize() : _total / pageBean.getPageSize() +1 ;
        pageBean.setTotalPage(totalPages);
        pageBean.setTotalCount(_total);
        //调用dao之前，确认分页要素准备完毕。
        System.out.println("pageBean = " + pageBean);
        List<Student> studentList = null;
        try {
            studentList = studentDao.getAllStu(pageBean);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

            //释放资源
            DruidConn.close(DruidConn.getConn(),null,null);
        }
        return studentList;
    }

}