package com.example.Employee;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.Employee.model.User;
import com.example.Employee.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context = SpringApplication.run(EmployeeApplication.class, args);
	EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
	//User user = new User("1001", "ram","kumar","ramkumar","mumbai", "ram@gmail.com", "9826281629","https://www.linkedin.com/ramkumar");
	//employeeRepository.save(user);
	//List<User> users = employeeRepository.findAll();
	//users.forEach(System.out::println);
	}

}
