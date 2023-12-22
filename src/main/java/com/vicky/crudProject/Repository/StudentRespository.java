package com.vicky.crudProject.Repository;


import com.vicky.crudProject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRespository extends JpaRepository<Student,Integer> {

}
