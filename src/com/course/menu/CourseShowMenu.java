package com.course.menu;

import com.course.service.ManagerService;

import java.util.Scanner;

public class CourseShowMenu {

        public static void ShowMenu(){
            Scanner sc = new Scanner(System.in);
            System.out.println("_________________________");
            System.out.println("    1.查看某一课程");
            System.out.println("    2.查看全部课程");
            System.out.println("_________________________");
            int a =sc.nextInt();
            switch(a){
                case 1:
                    ManagerService.manOneCourse();
                    break;
                case 2:
                    ManagerService.manAllCourse();
                default:
                    System.out.println("输入数字不合法，程序退出");
                    System.exit(0);
            }
        }

    }
