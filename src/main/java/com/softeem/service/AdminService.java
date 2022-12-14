package com.softeem.service;

import com.softeem.pojo.Admin;

/**
 * 创建作者 ：Mr.YJ
 * 创建时间 2022/12/9 16:41
 * 项目名称 Web_Student
 */
public interface AdminService {

    //注册
    int regAdmin(Admin admin);

    Admin checkAccount(String name);

    //登录业务
    Admin loginAdmin(Admin admin);
}
