package com.course.service;

import com.course.dao.ManagerDao;
import com.course.dao.impl.ManagerDaoImpl;
import com.course.menu.ManagerMenu;
import com.course.model.Course;
import com.course.model.Manager;
import com.course.model.User;

import java.util.Scanner;


public class ManagerService {
    static Scanner sc = new Scanner(System.in);
    //管理员登录
    public void manLogin(String username,String password){
        ManagerDao dao = new ManagerDaoImpl();
        Manager manager = new Manager();
        manager.setM_name(username);
        manager.setM_password(password);
        dao.login(manager);
        if(dao.login(manager)!=null){
            System.out.println("登录成功");
            ManagerMenu.ShowMenu();

        }
        else{
            System.out.println("用户名或密码错误");
        }
    }
    //添加课程
    public static void manAddCourse(){
        ManagerDao dao = new ManagerDaoImpl();
        Course course=new Course();
        System.out.println("请输入要填加的课程ID：");
        course.setC_id(sc.nextLine());
        System.out.println("请输入要填加的课程名：");
        course.setC_name(sc.nextLine());
        System.out.println("请输入要填加的课程教师：");
        course.setTeacher(sc.nextLine());
        dao.addCourse(course);
        ManagerMenu.ShowMenu();
    }
    //删除课程
    public static void manDeleteCourse(){
        ManagerDao dao = new ManagerDaoImpl();
        System.out.println("请输入要删除的课程ID：");
        String c_id = sc.nextLine();
        dao.deleteCourse(c_id);
        ManagerMenu.ShowMenu();
    }
    //修改课程
    public static void manUpdateCourse(){
        ManagerDao dao = new ManagerDaoImpl();
        Course course=new Course();
        System.out.println("请输入要修改的课程ID：");
        course.setC_id(sc.nextLine());
        System.out.println("请输入修改后的课程名：");
        course.setC_name(sc.nextLine());
        System.out.println("请输入修改后的课程教师：");
        course.setTeacher(sc.nextLine());
        dao.updateCourse(course);
        ManagerMenu.ShowMenu();
    }
    //查看某一课程
    public static void manOneCourse(){
        ManagerDao dao = new ManagerDaoImpl();
        System.out.println("请输入要查看的课程ID：");
        String c_id=sc.nextLine();
        dao.selectOneCourse(c_id);
        ManagerMenu.ShowMenu();
    }
    //查看全部课程
    public static void manAllCourse(){
        ManagerDao dao = new ManagerDaoImpl();
        System.out.println("已有课程如下：");
        dao.selectAllCourse();
        ManagerMenu.ShowMenu();
    }
    //添加学生
    public static void manAddUser(){
        ManagerDao dao = new ManagerDaoImpl();
        User user = new User();
        System.out.println("请输入要填加的学生用户名：");
        user.setUsername(sc.nextLine());
        System.out.println("请输入密码：");
        user.setPassword(sc.nextLine());
        dao.addUser(user);
        ManagerMenu.ShowMenu();
    }
    //删除学生
    public static void manDeleteUser(){
        ManagerDao dao = new ManagerDaoImpl();
        System.out.println("请输入要删除的用户名：");
        String username = sc.nextLine();
        dao.deleteUser(username);
        ManagerMenu.ShowMenu();
    }
    //修改学生
    public static void manUpdateUser(){
        ManagerDao dao = new ManagerDaoImpl();
        User user= new User();
        System.out.println("请输入要修改的用户名：");
        user.setUsername(sc.nextLine());
        System.out.println("请输入修改后的密码：");
        user.setPassword(sc.nextLine());
        dao.updateUser(user);
        ManagerMenu.ShowMenu();
    }
    //查看某一学生
    public static void manOneUser(){
        ManagerDao dao = new ManagerDaoImpl();
        System.out.println("请输入要查看的用户名：");
        String username=sc.nextLine();
        dao.selectOneUser(username);
        ManagerMenu.ShowMenu();
    }
    //查看全部学生
    public static void manAllUser(){
        ManagerDao dao = new ManagerDaoImpl();
        System.out.println("已有学生信息如下：");
        dao.selectAllUser();
        ManagerMenu.ShowMenu();
    }

}