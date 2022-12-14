package com.softeem.dao;

import com.softeem.pojo.Clazz;

import java.sql.SQLException;
import java.util.List;

public interface ClazzDao {
    List<Clazz> allClazz() throws SQLException;

}
