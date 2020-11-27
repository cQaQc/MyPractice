package my;

import mybatis.dao.AdminDao;
import mybatis.dao.BookesDao;
import mybatis.pojo.Admins;
import mybatis.pojo.Bookes;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import proxy.IUser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MyText {
    @Test
    public void springTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUser user = (IUser) context.getBean("user2");
        user.add();
        user.delete();
        user.update();
        user.query();
    }



    @Test
    public void mybatisTestAdmin(){

        SqlSession sqlSession = null;
        try {
            //通过Resources读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("sqlSessionConfig.xml");
            //通过配置文件去建立一个SqlSessionFactory工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //SqlSessionFactory工厂生产SqlSession对象
             sqlSession = sqlSessionFactory.openSession(true);
            //通过SqlSession对象，拿到动态代理对象
            AdminDao adminDao = sqlSession.getMapper(AdminDao.class);

/*          //万能map
            Map<String,Object> map = new HashMap<>();
            map.put("a",4);
            map.put("b","强强");
            map.put("c","999999");
            int add = adminDao.addByMap(map);
            if (add>0){
                System.out.println(map.get("b") + "插入成功！");
            }*/


            List<Admins> admins = adminDao.find();
            for (Admins a:admins
                 ) {
                System.out.println(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void mybatisTest(){

        SqlSession sqlSession = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlSessionConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession(true);
            BookesDao userDao = sqlSession.getMapper(BookesDao.class);

            Map map = new HashMap<>();
            map.put("bookname","java");
//            map.put("detail","从");
            List<Bookes> bookes = userDao.find(map);

            for (Bookes b : bookes
            ) {
                System.out.println(b);
            }

            List<Bookes> bookes1 = userDao.find(map);

            System.out.println("==============");
            System.out.println(bookes==bookes1);
            for (Bookes b : bookes1
            ) {
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }



    @Test
    public void mybatisTestUser(){

        SqlSession sqlSession = null;
        try {
            //通过Resources读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("sqlSessionConfig.xml");
            //通过配置文件去建立一个SqlSessionFactory工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //SqlSessionFactory工厂生产SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);
            //通过SqlSession对象，拿到动态代理对象
//            BookesDao userDao = sqlSession.getMapper(BookesDao.class);

            RowBounds rowBounds = new RowBounds(1, 2);

            List<Bookes> objects = sqlSession.selectList("mybatis.dao.BookesDao.getRowBounds",null,rowBounds);

            for (Bookes b : objects
            ) {
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }


    public String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-"," ");
    }


    @Test
    public void my(){
        System.out.println(getUUID());
        System.out.println(getUUID());
        System.out.println(getUUID());
    }










}
