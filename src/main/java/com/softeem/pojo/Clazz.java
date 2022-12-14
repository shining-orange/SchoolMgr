package com.softeem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: SchoolMgr
 * @description:
 * @author: DM
 * @create: 2022-12-09 09:40
 **/
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Clazz {
    private int cid;
    private String cname;
    private String assistTeacher;
}