package com.youyun.DAO;//為接口
import com.youyun.entity.T_dept;//為T_dept類

import java.util.List;

public interface Deptmapper {
    //增加部門
    public void addDept(T_dept dept);
    //更新部门信息
    public void updateDept(T_dept dept);
    //按id删除
    public void deletebyid(int id);
    //按id查询
    public T_dept findbyid(int id);
    //查询全部
    public List<T_dept> findall();


}
