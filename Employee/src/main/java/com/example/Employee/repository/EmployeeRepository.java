package com.example.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Employee.model.User;

public interface EmployeeRepository extends JpaRepository<User, String> {

	

}
