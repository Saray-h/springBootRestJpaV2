package com.springboot.springrestdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springrestdatajpa.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
 
}


