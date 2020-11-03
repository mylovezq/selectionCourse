package com.course.menu;

import com.course.service.UserService;

import java.util.Scanner;

public class StudentMenu {

        public static void showMenu(String username){
            Scanner sc = new Scanner(System.in);
            System.out.println("_________________________");
            System.out.println("      欢迎"+username+"使用选课系统         ");
            System.out.println("    1.修改学生密码");
            System.out.println("    2.查看已选课程");
            System.out.println("    3.选择可选课程");
            System.out.println("    4.查看可选课程");
            System.out.println("    5.删除已选课程");
            System.out.println("    6.退出选课系统");
            System.out.println("_________________________");
            int a = sc.nextInt();
            switch(a){
                case 1:  UserService.userChangePassWord(username);
                    break;
                case 2:  UserService.userStuCourse(username);
                    break;
                case 3:     UserService.userChooserCourse(username);
                    break;
                case 4:     UserService.userAvaCourse(username);
                    break;
                case 5:     UserService.userDeleteCourse(username);
                    break;
                case 6:  System.out.println("用户成功退出！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入数字不合法，程序退出");
                    System.exit(0);
            }


        }

    }
