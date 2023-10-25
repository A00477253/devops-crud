package com.vicky.crudProject.Repository;


import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vicky.crudProject.Entity.Student;

@Repository

public interface StudentRespository extends JpaRepository<Student,Integer> {

}
