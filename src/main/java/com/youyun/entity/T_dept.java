package com.youyun.entity;

public class T_dept {
  private long deptno;//部門號
  private String dname;//部門名
  private String loc;//部門

  //getXXX为读取，setXXX为赋值
  public long getDeptno() {
    return deptno;
  }

  public void setDeptno(long deptno) {
    this.deptno = deptno;
  }

  public String getDname() {
    return dname;
  }

  public void setDname(String dname) {
    this.dname = dname;
  }

  public String getDLoc() {
    return loc;
  }

  public void setLoc(String loc) {
    this.loc = loc;
  }
}
