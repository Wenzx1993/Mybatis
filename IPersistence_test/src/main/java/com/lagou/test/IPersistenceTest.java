package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        /**
         * 读取classpath下的配置文件sqlMapConfig.xml
         * 里面包含数据源信息与相应的mapper路径
         */
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        /**
         * 解析sqlMapConfig.xml对象
         * 构建Configuration对象
         * 生成连接池对象放入configuration中
         * 解析mapper.xml生成对象mappedStatementMap放入configuration中
         */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        /**
         * 创建SqlSession对象
         */
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
      /*  User user2 = sqlSession.selectOne("user.selectOne", user);

        System.out.println(user2);*/

       /* List<User> users = sqlSession.selectList("user.selectList");
        for (User user1 : users) {
            System.out.println(user1);
        }*/

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }


    }


    @Test
    public void douleTest() {
        double a = 0.3097;
        double b = 0.529;
        System.out.println(1-a-b-0.16);
    }



}
