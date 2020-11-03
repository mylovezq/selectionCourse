package com.course.dao;

import com.course.model.Course;
import com.course.model.Manager;
import com.course.model.User;

public interface ManagerDao {
    public Manager login(Manager manager);

    public void addCourse(Course course);
    public void deleteCourse(String c_id);
    public void updateCourse(Course course);
    public void selectOneCourse(String c_id);
    public void selectAllCourse();

    public void addUser(User user);
    public void deleteUser(String username);
    public void updateUser(User user);
    public void selectOneUser(String username);
    public void selectAllUser();

}