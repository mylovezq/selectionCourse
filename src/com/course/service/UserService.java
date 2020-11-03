package com.course.service;

import com.course.dao.UserDao;
import com.course.dao.impl.UserDaoImpl;
import com.course.menu.StudentMenu;
import com.course.model.User;

import java.util.Scanner;

public class UserService {
    static Scanner sc = new Scanner(System.in);
    public void userLogin(String username,String password){
        UserDao dao = new UserDaoImpl();
        User user =new User();
        user.setUsername(username);
        user.setPassword(password);
        dao.login(user);
        if(dao.login(user)!=null){
            System.out.println("登录成功");
            StudentMenu.showMenu(username);
        }
        else{
            System.out.println("用户名或密码错误");
        }

    }
    public static void userChangePassWord(String username){
        UserDao dao = new UserDaoImpl();
        User user =new User();
        System.out.println("请输入新密码");
        String password = sc.nextLine();
        if(password==""||password.length()>10){
            System.exit(0);
        }
        else{
            user.setUsername(username);
            user.setPassword(password);
            dao.changePass(user);
            System.out.println("修改密码成功，新密码为："+password);
            StudentMenu.showMenu(username);
        }

    }
    public static void userStuCourse(String username){
        UserDao dao = new UserDaoImpl();
        System.out.println("_________________________");
        System.out.println("已选课程为：");
        dao.getStuCourse(username);
        StudentMenu.showMenu(username);
    }
    public static void userDeleteCourse(String username){
        UserDao dao = new UserDaoImpl();
        System.out.println("_________________________");
        System.out.println("想要删除的课程ID为：");
        String c_id=sc.nextLine();
        dao.deleteCourse(username, c_id);
        StudentMenu.showMenu(username);

    }
    public static void userAvaCourse(String username){
        UserDao dao = new UserDaoImpl();
        System.out.println("_________________________");
        System.out.println("可选课程为：");
        dao.getAvaCourse(username);
        StudentMenu.showMenu(username);
    }
    public static void userChooserCourse(String username){
        UserDao dao = new UserDaoImpl();
        System.out.println("_________________________");
        System.out.println("想要选择的课程ID为：");
        String c_id=sc.nextLine();
        dao.chooseCourse(username, c_id);
        StudentMenu.showMenu(username);
    }

}