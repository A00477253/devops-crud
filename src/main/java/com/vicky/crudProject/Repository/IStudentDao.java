package com.vicky.crudProject.Repository;

import com.vicky.crudProject.Entity.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> getStudentByName(String name);
}
