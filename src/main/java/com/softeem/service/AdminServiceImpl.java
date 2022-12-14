package com.softeem.service;

import com.softeem.dao.AdminDao;
import com.softeem.dao.AdminDaoImpl;
import com.softeem.pojo.Admin;

import java.sql.SQLException;

/**
 * 创建作者 ：Mr.YJ
 * 创建时间 2022/12/9 16:41
 * 项目名称 Web_Student
 */
public class AdminServiceImpl implements AdminService{

    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public int regAdmin(Admin admin) {
        int add = 0;
        try {
            add = adminDao.addAdmin(admin);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return add;
    }

    @Override
    public Admin checkAccount(String name) {
        Admin admin = null;
        try {
            admin = adminDao.checkAccount(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return admin;
    }

    @Override
    public Admin loginAdmin(Admin admin) {
        Admin a = null;
        try {
            a = adminDao.selectAdmin(admin);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return a;
    }
}
