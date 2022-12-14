package com.softeem.service;

import com.softeem.pojo.Student;
import com.softeem.util.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    List<Student> getAllStu();
    boolean delStuById(String id);
    boolean updStu(Student student);
    boolean addStu(Student student);
    Student getStuByid(String id);

    List<Student> getAllStu(PageBean pageBean);
}
