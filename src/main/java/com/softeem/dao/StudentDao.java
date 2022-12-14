package com.softeem.dao;

import com.softeem.pojo.Student;
import com.softeem.util.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student> getAllStu() throws SQLException;
    boolean delStuById(String id) throws SQLException;
    boolean updStu(Student student) throws SQLException;
    boolean addStu(Student student) throws SQLException;
    Student getStuByid(String id) throws SQLException;
    //分页查询
    List<Student> getAllStu(PageBean pageBean) throws SQLException;

    long getAllCount(PageBean pageBean) throws SQLException;
}
