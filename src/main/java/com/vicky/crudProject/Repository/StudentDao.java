package com.vicky.crudProject.Repository;


import com.vicky.crudProject.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao implements IStudentDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getStudentByName(String name){
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery=criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot=criteriaQuery.from(Student.class);
        Predicate namePredicate=criteriaBuilder.equal(studentRoot.get("name"),name);
        Predicate mobilePredicate=criteriaBuilder.equal(studentRoot.get("mobileNumber"),"8667266112");
        Predicate combinedPredicate = criteriaBuilder.and(namePredicate, mobilePredicate);
        criteriaQuery.where(combinedPredicate);
        TypedQuery<Student> query=entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
