package com.hdbc.demo;

import com.jdbc.demo.JdbcDemo;

public class Test {


    @org.junit.Test
    public void testOne() {
        JdbcDemo jdbcDemo = new JdbcDemo();
        jdbcDemo.excuteSql();
    }
}
