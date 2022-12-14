package com.softeem.service;

import com.softeem.dao.ClazzDao;
import com.softeem.dao.ClazzDaoImpl;
import com.softeem.pojo.Clazz;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-09 09:45
 **/

public class ClazzServiceImpl implements ClazzService{
    ClazzDao clazzDao=new ClazzDaoImpl();
    @Override
    public List<Clazz> allClazz() {
        List<Clazz> clazzList=null;
        try {
            clazzList=clazzDao.allClazz();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clazzList;
    }
}