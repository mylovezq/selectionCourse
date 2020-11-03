package com.course;

import com.course.service.ManagerService;
import com.course.service.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用选课系统");
        System.out.println("请输入登录名：");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        System.out.println("请选择您的身份");
        System.out.println("1.管理员");
        System.out.println("2.学生");
        int a = sc.nextInt();
        switch(a){
            case 1:
                new ManagerService().manLogin(username, password);
                break;
            case 2:
                new UserService().userLogin(username, password);
                break;
            default:
                System.out.println("输入数字不合法，程序退出");
                System.exit(0);
        }
    }

}