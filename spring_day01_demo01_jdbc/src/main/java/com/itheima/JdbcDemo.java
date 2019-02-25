package com.itheima;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {

        //编译时依赖
//        DriverManager.registerDriver(new Driver());

        //运行时依赖
        Class.forName("com.mysql.jdbc.Driver");

        String sql = "select * from user";

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "root");

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            String username = resultSet.getString("username");
            String address = resultSet.getString("address");
            System.out.println(username+":"+address);
        }

    }
}
