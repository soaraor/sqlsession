package com.youyun.DAO;

import com.youyun.entity.Dept1;
import com.youyun.entity.T_dept;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;


public class mybatistest{

    /**
     * 测试insert方法
     * @throws IOException
     */
    @Test
    public void testInsert() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =  new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        //调用addDept操作
        T_dept dept = new T_dept();
        dept.setDeptno((long)11);
        dept.setDname("bale");
        dept.setLoc("walse");
        session.insert("addDept", dept);
        System.out.println("\n"+"第一部分：insert运行成功！"+"\n");
        session.commit();
        //关闭
        session.close();
    }//---------------------------------------------------------测试可用

    /**
     * 测试update方法
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =  Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =   new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        //调用findbyid操作
        T_dept dept = (T_dept)session.selectOne("findbyid",3);
        dept.setDname("fate");
        dept.setLoc("qiqihaer");
        //调用updateDept操作
        session.update("updateDept",dept);
        System.out.println("第二部分：update运行成功！");
        session.commit();
        //关闭
        session.close();
    }//---------------------------------------------------------测试可用

    /**
     * 测试删除方法
     * @throws IOException
     */
    @Test
    public void testDelete() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        //调用deletebyid操作
        session.delete("deletebyid",55);
        System.out.println("第三部分：deletebyid运行成功！");//这里如果重写几个类似的方法，载入用户输入请求，可以实现按输入条件删除？
        session.commit();
        //关闭
        session.close();
    }//---------------------------------------------------------测试可用

    /**
     * 测试根据Id查询方法
     * @throws IOException
     */
    @Test
    public void testFindById() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        // 创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        // 创建Session
        SqlSession session = sf.openSession();

        // 调用findbyid方法
        T_dept dept = (T_dept)session.selectOne("findbyid", 40);
        System.out.println("ID："+dept.getDeptno() + " ， "+"部门："+ dept.getDname() + " ， " +"地址："+ dept.getDLoc());
        System.out.println("第四部分：findbyid运行成功！");
        // 关闭
        session.close();
    }//---------------------------------------------------------测试可用

    /**
     * 测试查询全部数据
     * @throws IOException
     */
    @Test
    public void testFindAll() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        // 创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        // 创建Session
        SqlSession session = sf.openSession();

        // 调用findAll方法
        List<T_dept> list = session.selectList("findall");
        for (T_dept dept : list){
            System.out.println(dept.getDeptno() + "\t" + dept.getDname() + "\t" + dept.getDLoc());
        }
        System.out.println("第五部分：findall运行成功！");
        session.close();
    }//---------------------------------------------------------测试可用

    /**
     * 测试分页查询数据（控制抓取记录的起点和数量）
     * @throws IOException
     */
    @Test
    public void testFindPage() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =  Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        int start = 5;//起点
        int offset = 9;
        RowBounds rowBounds = new RowBounds(start, offset);
        List<T_dept> list =  session.selectList("findall",null,rowBounds);
        for(T_dept dept : list){
            System.out.println(dept.getDeptno()+" "
                    +dept.getDname()+" "
                    +dept.getDLoc());
        }
        session.close();
    }//---------------------------------------------------------测试可用

    /**
     * 以map映射实现返回部门对象
     * @throws IOException
     */
    @Test
    public void findDept() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        Map map = (Map)session.selectOne("findDept",40);
        System.out.println(map.get("deptno") +"\t"+map.get("dname")+"\t"+map.get("loc"));

        session.close();
    }//---------------------------------------------------------测试可用

    /**
     * 使用Mapper对T_dept表操作案例
     * @throws IOException
     */
    @Test
    public void testDeptmapper() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        Deptmapper mapper = session.getMapper(Deptmapper.class);//生成mapper接口实例

        //调用findall方法
        List<T_dept> list = mapper.findall();
        for (T_dept dept:list){
            System.out.println(dept.getDeptno()+"\t"+dept.getDname()+"\t"+dept.getDLoc());
        }
        System.out.println("序列大小："+list.size());
        session.close();
    }

    /**
     * 测试自定义映射返回（实体类class与数据库表db.table的字段不一致时，用实体字段映射DB字段并返回DB数据）
     * @throws IOException
     */
    @Test
    public void testResultMap() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =  new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        Deptmapper mapper = session.getMapper(Deptmapper.class);

        //调用findAll1方法
        List<Dept1> list = mapper.findall1();
        for(Dept1 dept : list){
            System.out.println(dept.getNo() + " " + dept.getName() + " " + dept.getAddr());
        }
        System.out.println(list.size());
        session.close();
    }
}
