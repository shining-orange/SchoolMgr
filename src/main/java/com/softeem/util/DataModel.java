package com.softeem.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-09 17:06
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DataModel {
    private Integer code;//状态码
    private String msg;//响应内容
    private Object data;//数据源
    private Integer count;//数据总数

    public void setCounts(int i) {
    }
}