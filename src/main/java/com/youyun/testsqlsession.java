package com.youyun;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class testsqlsession {

    /**
     * 获取SqlSession对象案例
     * @throws IOException
     */
    @Test
    public void testSqlSession() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =  Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =  new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();
        System.out.println(session);
        //关闭Session
        session.close();
    }

}