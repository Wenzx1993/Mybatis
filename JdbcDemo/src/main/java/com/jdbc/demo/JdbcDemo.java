package com.jdbc.demo;

import java.sql.*;

public class JdbcDemo {

    public void excuteSql() {
        //获取连接
        Connection connection = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://10.0.10.3:3309/test","root","12345");
            //sql语句预处理器
            PreparedStatement preparedStatement = connection.prepareStatement("select * from  user where id = ?");
            //设置参数
            preparedStatement.setInt(1,5);
            //执行sql
            ResultSet resultSet = preparedStatement.executeQuery();
            //解析返回值
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id+"——"+name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭连接
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
