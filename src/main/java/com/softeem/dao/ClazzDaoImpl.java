package com.softeem.dao;

import com.softeem.pojo.Clazz;
import com.softeem.util.DruidConn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-09 09:41
 **/

public class ClazzDaoImpl implements ClazzDao{
    QueryRunner qr = new QueryRunner(DruidConn.getDataSource());
    public List<Clazz> allClazz() throws SQLException {
        String sql="select * from class";
        return qr.query(sql,new BeanListHandler<Clazz>(Clazz.class));
    }

}