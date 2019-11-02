package com.hcc.oAuth2WithMySql.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = -4279853038897645550L;
	
	@Id
	long id;
	int age;
	String firstName;
	String lastName;
	String password;
	double salary;
	String username;
	String role;

}
