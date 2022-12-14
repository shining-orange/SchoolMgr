package com.softeem.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: JavaWeb
 * @description:
 * @author: dm
 * @create: 2022-12-06 20:05
 **/

public class DruidConn {

    private DruidConn() {};

    // 数据库连接池
    private static DruidDataSource druidDataSource;

    static {

        // 配置文件操作类
        Properties properties = new Properties();

        try {
            // 读取配置文件资源
            properties.load(DruidConn.class.getClassLoader().getResourceAsStream("druid.properties"));

            // 创建连接池
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

/*    static {
        try {
            //读取文件配置资源
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            InputStream is = DruidConn.class.getResourceAsStream("/druid.properties");

            //加载驱动
            properties.load(is);

            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 数据库连接
     * @return 连接对象
     */
    public static Connection getConn() {

        try {
            // 通过连接池获得连接对象
            return druidDataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("超出连接数量！");
            e.printStackTrace();
        }
        return null;
    }

    //获取数据源
    public static DruidDataSource getDataSource() {
        return druidDataSource;
    }

    /**
     * 关闭资源
     * @param connection 连接
     * @param preparedStatement SQL操作
     * @param resultSet 结果集
     */
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){

        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭数据库俩捏
     * @param conn 传入数据库链接
     */
    public static void close(Connection conn){
        try {
            if(conn !=null){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}