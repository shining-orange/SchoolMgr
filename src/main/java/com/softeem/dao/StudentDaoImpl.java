package com.softeem.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.softeem.pojo.Student;
import com.softeem.util.DruidConn;
import com.softeem.util.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-07 16:11
 **/

public class StudentDaoImpl implements StudentDao{
    // 调用连接池工具类方法实现连接数据库
    QueryRunner qr = new QueryRunner(DruidConn.getDataSource());
    @Override
    public List<Student> getAllStu() throws SQLException {
        String sql="select * from student";
        List<Student> studentList=qr.query(sql,new BeanListHandler<Student> (Student.class));
        return studentList;

    }

    @Override
    public boolean delStuById(String id) throws SQLException {
        String sql="delete from student where sno=?";
        int update = qr.update( sql, id);
        return update>0?true:false;
    }

    @Override
    public boolean updStu(Student student) throws SQLException {
        String sql="update student set sname=?, password=?, sex=?, score=?, phone=?, birthday=?, status=?, cid=? where sno=?";
        int update= qr.update(DruidConn.getConn(), sql, student.getSname(),
                student.getPassword(), student.getSex(), student.getScore(),
                student.getPhone(), student.getBirthday(), student.getStatus(), student.getCid(), student.getSno());
        return update>0?true:false;
    }

    @Override
    public boolean addStu(Student student) throws SQLException {
        String sql="insert into student(sname,password,sex,score,phone,birthday,status,cid) value(?,?,?,?,?,?,?,?)";
        int update = qr.update(sql, student.getSname(), student.getPassword(), student.getSex(), student.getScore(), student.getPhone(), student.getBirthday(), student.getStatus(), student.getCid());
        return update>0?true:false;
    }

    @Override
    public Student getStuByid(String id) throws SQLException {
        String sql="select * from student where sno=?";
        return qr.query(sql,id,new BeanHandler<Student>(Student.class));

    }

    @Override
    public List<Student> getAllStu(PageBean pageBean) throws SQLException {
//        String sql = "select * from student limit ?,?";
//        int pageSize= pageBean.getPageSize();
//        int start=(pageBean.getPageNum()-1)*pageSize;
//        return qr.query(DruidConn.getConn(),sql,new BeanListHandler<Student>(Student.class),start,pageSize);

//        String sql = "select * from student,class where 1=1 ";
        String sql = "select * from student s,class c where s.cid = c.cid ";
        if (pageBean.getSname()!=null && !pageBean.getSname().equals("")){
            sql += " and sname like '%"+pageBean.getSname()+"%' ";
        }
        if (pageBean.getScoreFrom()!=null && !pageBean.getScoreFrom().equals("")){
            sql += " and score >= " + pageBean.getScoreFrom();
        }
        if (pageBean.getScoreTo()!=null && !pageBean.getScoreTo().equals("")){
            sql += " and score <= " + pageBean.getScoreTo();
        }
        if (pageBean.getCid()!=null && !pageBean.getCid().equals("")) {
            sql += " and s.cid = " + pageBean.getCid();
        }
        if (pageBean.getBirthFrom()!=null && !pageBean.getBirthFrom().equals("")){
            sql += " and birthday >= '" + pageBean.getBirthFrom() +"' ";
        }
        if (pageBean.getBirthTo()!=null && !pageBean.getBirthTo().equals("")){
            sql += " and birthday <= '" + pageBean.getBirthTo() + "' ";
        }
        // 第1个问号当前页的第一个学生所在整个数据的位置 ，第2个问号每页条数
        //每页3条，查看第1页的数据          每页3条
        //select * from student limit 0,3  第1页，起始数据位置0
        //		查看第2页的数据
        //SELECT * from student limit 3,3  第2页，起始数据位置3
        //		查看第3页的数据
        //SELECT * from student limit 6,3  第3页，起始数据位置6
        //                                 第n页，起始数据位置（n-1）*3
        //   n 为 当前页 ，3为每页条数
        sql += " order by s.sno limit ?,?";
        //默认根据班级id排序，自定义order by根据学号排序，每次添加的学生最后，页面显示点击尾页看到最新添加的学生
        int pageSize = pageBean.getPageSize();
        int start = (pageBean.getPageNum()-1)*pageSize;
        return qr.query(sql,new BeanListHandler<Student>(Student.class),start,pageSize);
    }

   //获取分页的个数
    public long getAllCount(PageBean pageBean) throws SQLException {
        //        String sql = "SELECT count(*) from student";
        String sql = "SELECT count(*) from student s,class c where s.cid = c.cid ";
        if (pageBean.getSname()!=null && !pageBean.getSname().equals("")){
            sql += " and sname like '%"+pageBean.getSname()+"%' ";
        }
        if (pageBean.getScoreFrom()!=null && !pageBean.getScoreFrom().equals("")){
            sql += " and score >= " + pageBean.getScoreFrom();
        }
        if (pageBean.getScoreTo()!=null && !pageBean.getScoreTo().equals("")){
            sql += " and score <= " + pageBean.getScoreTo();
        }
        if (pageBean.getCid()!=null && !pageBean.getCid().equals("")) {
            sql += " and s.cid = " + pageBean.getCid();
        }
        if (pageBean.getBirthFrom()!=null && !pageBean.getBirthFrom().equals("")){
            sql += " and birthday >= '" + pageBean.getBirthFrom() +"' ";
        }
        if (pageBean.getBirthTo()!=null && !pageBean.getBirthTo().equals("")){
            sql += " and birthday <= '" + pageBean.getBirthTo() + "' ";
        }
        return qr.query(sql,new ScalarHandler<Long>()); //转换查询的记录数
    }
}