package com.course.model;

public class Course {
    private String c_id;
    private String c_name;
    private String teacher;

    public String getC_id() {
        return c_id;
    }
    public void setC_id(String i) {
        this.c_id = i;
    }
    public String getC_name() {
        return c_name;
    }
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }


}