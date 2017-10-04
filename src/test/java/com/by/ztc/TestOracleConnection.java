package com.by.ztc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by byvai on 2017/10/4.
 *
 * 测试数据库连接 Oracle
 *
 * @author zwp
 *
 */
public class TestOracleConnection {

    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@192.168.199.194:1521:orcl";
        //            jdbc:oracle:thin:@localhost:1521:orcl
        String user = "c##jtaq";
        String password = "aaBB124";
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("连接成功！");
        String sql = "SELECT * FROM test2 t2";
        PreparedStatement pre = con.prepareStatement(sql);
        ResultSet result = pre.executeQuery();
        while (result.next()) {
            System.out.println(result.getString("t"));
        }
    }


}

// TODO -
// 出现的问题
// plsql可以连接
// 但是程序连接失败、SQL plus连接失败