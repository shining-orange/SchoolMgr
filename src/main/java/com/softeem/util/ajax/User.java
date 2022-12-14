package com.softeem.util.ajax;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-12 14:34
 **/
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
    private Integer age;
}