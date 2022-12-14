package com.softeem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

  private long sno;
  private String sname;
  private String password;
  private String sex;
  private long score;
  private String phone;
  private java.sql.Date birthday;
  private long status;
  private long cid;
  private String cname;
}
