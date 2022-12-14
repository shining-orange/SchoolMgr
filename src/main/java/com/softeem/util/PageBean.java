package com.softeem.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-08 11:24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageBean {//分页的工具类
    private Integer pageNum;//当前页
    private Integer pageSize=8;//每页显示的条数
    private Integer totalPage;//总页数
    private Integer totalCount;//总条数


    private String sname;
    private String scoreFrom;
    private String scoreTo;
    private String cid;
    private String birthFrom;
    private String birthTo;

}