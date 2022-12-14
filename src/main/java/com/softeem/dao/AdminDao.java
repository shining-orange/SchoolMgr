package com.softeem.dao;

import com.softeem.pojo.Admin;

import java.sql.SQLException;

/**
 * 创建作者 ：Mr.YJ
 * 创建时间 2022/12/9 16:35
 * 项目名称 Web_Student
 */
public interface AdminDao {
    //添加  （注册为业务）
    int addAdmin(Admin admin) throws SQLException;

    Admin checkAccount(String name) throws SQLException;

    //管理员登录（用户名和密码）：方法参数两种：一种是用户和密码两个参数，用户和密码封装到admin
    // 思路：根据提供的用户信息，查询数据库，返回数据非空（查询有该用户），登录成功
    Admin selectAdmin(Admin admin) throws SQLException;
}
