package com.softeem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-09 16:36
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {
    private Integer id;
    private String name;
    private String password;
    private String headimg;
}