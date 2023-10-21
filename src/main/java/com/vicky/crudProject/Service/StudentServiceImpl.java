package com.vicky.crudProject.Service;

import com.vicky.crudProject.Entity.Student;
import com.vicky.crudProject.Repository.IStudentDao;
import com.vicky.crudProject.Repository.StudentRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRespository studentRespository;

    @Autowired
    private IStudentDao studentDao;

    @Override
    public Student saveStudent(Student student) {
        log.info("The student object is "+student);
        return studentRespository.save(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRespository.findById(id).get();
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentDao.getStudentByName(name);
    }
}
