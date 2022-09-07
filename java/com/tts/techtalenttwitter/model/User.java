package com.tts.techtalenttwitter.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data		 // generates getter and setters
			// generates a default toString

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_profile")


public class User {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Long id;
	
	@Email(message="please provide a valid email")
	@NotEmpty(message ="Please provide an email")
	private String email;
	
	@Length(min=3, message = "your username must have at least 3 characters")
	@Length(max=15,message = "your username can have more than 15 characters")
	@Pattern(regexp= "[^||$]+", message = "your username cannot contain spaces")
	private String username;
	
	@Length(min=5, message = "your password must have at least 5 characters")	
	private String password;
	
	@NotEmpty(message = "Please provide your first name")
	private String firstName;
	
	@NotEmpty(message = "Please provide your last name")
	private String lastName;
	
	@NotEmpty(message = "Please provide your active  name")
	private int active;
	
	
	@CreationTimestamp
	private Date createdAt;
	
	
	// this will associate  roles with a user.
	// this is a collection
	// we generally do no store multiple elements 
	/// in a single file in a  database
	// how is this going to represent with JPA
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	
	private Set<Role>roles;

		
	}
	

















