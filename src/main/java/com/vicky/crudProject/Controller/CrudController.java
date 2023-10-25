package com.vicky.crudProject.Controller;


import com.vicky.crudProject.Entity.Student;
import com.vicky.crudProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class CrudController {

    @Autowired
    private StudentService studentService;



    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable(name="id")Integer id){
        return studentService.getStudentById( id);
    }

    @GetMapping("getByName/{studentName}")
    public List<Student> getStudentByName(@PathVariable(name="studentName") String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/loveInfinite")
    public String loveMessage(){
        return "I love you and krishvi kutty from canada with lots of love";
    }
}
