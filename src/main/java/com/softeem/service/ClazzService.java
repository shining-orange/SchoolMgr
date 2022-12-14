package com.softeem.service;

import com.softeem.pojo.Clazz;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-09 09:45
 **/

public interface ClazzService {
    List<Clazz> allClazz();
}