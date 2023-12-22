package com.vicky.crudProject.Controller;


import com.vicky.crudProject.DTO.AuthRequest;
import com.vicky.crudProject.Entity.Student;
import com.vicky.crudProject.Entity.User;
import com.vicky.crudProject.Service.JWTService;
import com.vicky.crudProject.Service.StudentService;
import com.vicky.crudProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/student")
public class CrudController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/getStudent/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Student getStudentById(@PathVariable(name="id")Integer id){
        return studentService.getStudentById( id);
    }

    @GetMapping("getByName/{studentName}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Student> getStudentByName(@PathVariable(name="studentName") String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("getStudents")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Welcome to spring security";
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody  User user){
        return userService.addUser(user);
    }

    @PostMapping ("/auth")
    public String authenticateGetToken(@RequestBody AuthRequest authRequest){
        var auth=authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken
                        (authRequest.getUsername(),authRequest.getPassword()));
        if(auth.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }
        else{
            throw new UsernameNotFoundException("Invalid user");
        }


    }





}
