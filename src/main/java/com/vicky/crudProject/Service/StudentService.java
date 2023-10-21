package com.vicky.crudProject.Service;

import com.vicky.crudProject.Entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    Student getStudentById(Integer id);

    List<Student> getStudentByName(String name);
}
