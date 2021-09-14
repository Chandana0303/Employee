package com.example.Employee.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.model.User;
import com.example.Employee.repository.EmployeeRepository;

@EnableTransactionManagement
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployees()
	{
		List<User> users = employeeRepository.findAll();
		if(users.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(users);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No data found");
		}
	}
	
	@PostMapping("/createEmployee")
	public ResponseEntity<?> newEmployee(@Valid @RequestBody User users)
	{
		if(employeeRepository.existsById(users.getUser_id()))
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body("record already exists");
		}
		if(employeeRepository.existsById(users.getLogin_name()))
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body("login_name already exists");
		}
		User user1 = employeeRepository.save(users);
		System.out.println(user1);
		if(user1!=null)
		{
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	
}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Data not created");
		}
	}
	
	@Transactional
	@PutMapping("/putemployee/{id}")
	public ResponseEntity<?> updateEmployee(@RequestBody User users) {
		
		try {
			return new ResponseEntity<User>(employeeRepository.save(users), HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delemployee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String id) 
		{
			Optional<User> users = employeeRepository.findById(id);
			if (users.isPresent()) 
			{
			employeeRepository.delete(users.get());
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} 
			else
			{
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
}
