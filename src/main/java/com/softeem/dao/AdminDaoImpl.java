package com.softeem.dao;

import com.softeem.pojo.Admin;
import com.softeem.util.DruidConn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * 创建作者 ：Mr.YJ
 * 创建时间 2022/12/9 16:36
 * 项目名称 Web_Student
 */
public class AdminDaoImpl implements AdminDao{

    QueryRunner qr = new QueryRunner(DruidConn.getDataSource());
    @Override
    public int addAdmin(Admin admin) throws SQLException {
        String sql = "insert into admin(name,password,headimg) value(?,?,?)";
        return qr.update(sql,admin.getName(),admin.getPassword(),admin.getHeadimg());
    }

    @Override
    public Admin checkAccount(String name) throws SQLException {
        String sql = "select * from admin where name = ?";
        return qr.query(sql,new BeanHandler<Admin>(Admin.class),name);
    }

    @Override
    public Admin selectAdmin(Admin admin) throws SQLException {
        String sql = "select * from admin where name = ? and password = ?";
        return qr.query(sql,new BeanHandler<Admin>(Admin.class),admin.getName(),admin.getPassword());
    }
}
