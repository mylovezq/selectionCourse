package com.course.dao.impl;

import com.course.dao.UserDao;
import com.course.model.Course;
import com.course.model.User;
import com.course.utils.BaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDaoImpl implements UserDao {

    @Override
    public User login(User user) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con= BaseConnectionUtil.getCon();
            String sql="select * from user where username=? and password=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs=ps.executeQuery();
            User users=null;
            if(rs.next()){
                users=new User();
                //从数据库中获取值设置到实体类的setter方法中
                users.setUsername(rs.getString("username"));
                users.setPassword(rs.getString("password"));
                return users;
            }else{
                return null;
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changePass(User user) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();
            String sql = "update user set password=? where username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getUsername());
            int a =ps.executeUpdate();

        }    catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void chooseCourse(String username,String c_id) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con= BaseConnectionUtil.getCon();
            String sql ="insert into user_course (username,c_id) values(?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, c_id);
            int a =ps.executeUpdate();
            if(a>0){
                System.out.println("选课成功");
            }
            else{
                System.out.println("输入ID有误，选课失败");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //删除选课
    @Override
    public void deleteCourse(String username,String c_id) {
        // TODO Auto-generated method stub

        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();
            String sql="delete from user_course where username=? and c_id=? ";
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, c_id);
            int a =ps.executeUpdate();
            if(a>0){
                System.out.println("删除成功");
            }
            else{
                System.out.println("输入ID有误，删除失败");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //查询已选课程
    @Override
    public void getStuCourse(String username) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();

            String sql ="select * from course where c_id in (select c_id from user_course where username=?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            rs=ps.executeQuery();
            while (rs.next()) {
                //System.out.println(6);
                Course course = new Course();
                course.setC_id(rs.getString("c_id"));
                course.setC_name(rs.getString("c_name"));
                course.setTeacher(rs.getString("teacher"));

                System.out.println(course.getC_id()+" "+course.getC_name()+" "+course.getTeacher());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    //查询可选课程
    @Override
    public void getAvaCourse(String username) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();
            String sql = "select * from course where c_id not in (select c_id from user_course where username=?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            rs=ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setC_id(rs.getString("c_id"));
                course.setC_name(rs.getString("c_name"));
                course.setTeacher(rs.getString("teacher"));

                System.out.println(course.getC_id()+" "+course.getC_name()+" "+course.getTeacher());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}