package com.course.dao.impl;

import com.course.dao.ManagerDao;
import com.course.model.Course;
import com.course.model.Manager;
import com.course.model.User;
import com.course.utils.BaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class ManagerDaoImpl implements ManagerDao {
    //管理员登录
    @Override
    public Manager login(Manager manager) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con= BaseConnectionUtil.getCon();
            String sql="select * from manager where m_name=? and m_password=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, manager.getM_name());
            ps.setString(2, manager.getM_password());
            rs=ps.executeQuery();
            Manager  managers=null;
            if(rs.next()){
                managers=new Manager();
                managers.setM_name(rs.getString("m_name"));
                managers.setM_password(rs.getString("m_password"));
                return managers;

            }
            else
                return null;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    //添加课程
    @Override
    public void addCourse(Course course) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();
            String sql="insert into course (c_id,c_name,teacher) values(?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, course.getC_id());
            ps.setString(2, course.getC_name());
            ps.setString(3, course.getTeacher());
            int a = ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //删除课程
    @Override
    public void deleteCourse(String c_id) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();
            String sql = "delete from course where c_id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, c_id);
            int a=ps.executeUpdate();
            if(a>0){
                System.out.println("删除成功");
                String sql2="delete from user_course where c_id=?";
                ps=con.prepareStatement(sql2);
                ps.setString(1, c_id);
                int b=ps.executeUpdate();
            }
            else{
                System.out.println("输入ID有误，删除失败");
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //修改课程
    @Override
    public void updateCourse(Course course) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();
            String sql="update course set c_name=?,teacher=? where c_id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, course.getC_name());
            ps.setString(2, course.getTeacher());
            ps.setString(3, course.getC_id());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("课程修改成功");
            }
            else{
                System.out.println("输入ID有误，课程修改失败");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //    查看某一课程
    @Override
    public void selectOneCourse(String c_id) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();
            String sql ="select * from course where c_id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, c_id);
            rs=ps.executeQuery();
            Course course=null;
            if(rs.next()){
                course = new Course();
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
    //查看全部课程
    @Override
    public void selectAllCourse() {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();
            String sql ="select * from course ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            Course course=null;
            while(rs.next()){
                course = new Course();
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
    //添加学生
    @Override
    public void addUser(User user) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();
            String sql="insert into user (username,password) values(?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("学生添加成功");
            }
            else{
                System.out.println("学生添加失败");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //删除学生
    @Override
    public void deleteUser(String username) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();
            String sql = "delete from user where username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            int a=ps.executeUpdate();
            if(a>0){
                System.out.println("删除成功");
                String sql2="delete from user_course where username=?";
                ps=con.prepareStatement(sql2);
                ps.setString(1, username);
                int b=ps.executeUpdate();
            }
            else{
                System.out.println("输入用户名有误，删除失败");
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //修改用户
    @Override
    public void updateUser(User user) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();
            String sql="update user set password=? where username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getUsername());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("用户修改成功");
            }
            else{
                System.out.println("输入有误，用户修改失败");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //查看某一学生
    @Override
    public void selectOneUser(String username) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();
            String sql ="select * from user where username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            rs=ps.executeQuery();
            User user=null;
            if(rs.next()){
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                System.out.println(user.getUsername()+" "+user.getPassword());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //查看全部课程
    @Override
    public void selectAllUser() {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseConnectionUtil.getCon();
            String sql ="select * from user ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            User user=null;
            while(rs.next()){
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                System.out.println(user.getUsername()+" "+user.getPassword());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}