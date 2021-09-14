package com.example.Employee.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

@Entity
@Table(name = "user")
public class User {
	
	@Id
	private String user_id;
	private String first_name;
	private String last_name;
	private String login_name;
	private String address;
	private String email;
	private String mobile;
	private String linkedin_url;

}
