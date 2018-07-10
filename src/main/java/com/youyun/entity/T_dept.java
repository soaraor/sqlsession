package com.youyun.entity;

public class T_dept {
  private Long deptno;//部門號
  private String dname;//部門名
  private String loc;//部門

  public Long getDeptno() {
    return deptno;
  }

  public void setDeptno(Long deptno) {
    this.deptno = deptno;
  }

  public String getDname() {
    return dname;
  }

  public void setDname(String dname) {
    this.dname = dname;
  }

  public String getLoc() {
    return loc;
  }

  public void setLoc(String loc) {
    this.loc = loc;
  }
}
