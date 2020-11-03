package com.course.utils;

import java.sql.*;

public class BaseConnectionUtil {

    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://49.235.231.57:3306/kongzhitaixuanke?useUnicode=true&characterEncoding=utf-8";
    private static String user="root";
    private static String password="ROOTroot123+-*/";

    /**
     * 连接数据库
     * @throws Exception
     */
    public static Connection getCon () throws Exception{
        Class.forName(driver);
        //System.out.println("加载");
        Connection con =DriverManager.getConnection(url, user, password);
        //System.out.println("连接");
        return con;
    }
    /**
     * 关闭数据库
     */
    public static void close(Connection con,PreparedStatement ps,ResultSet rs){
        if(rs!=null){//关闭资源，避免出现异常
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(ps!=null){//关闭资源，避免出现异常
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(con!=null){//关闭资源，避免出现异常
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        try {
            BaseConnectionUtil.getCon();
            System.out.println("成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}