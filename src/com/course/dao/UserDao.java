package com.course.dao;

import com.course.model.User;

public interface UserDao {
    public User login(User user);
    public void changePass(User user);
    public void getStuCourse(String username);
    public void getAvaCourse(String username);
    public void chooseCourse(String username,String c_id);
    public void deleteCourse(String username,String c_id);

}