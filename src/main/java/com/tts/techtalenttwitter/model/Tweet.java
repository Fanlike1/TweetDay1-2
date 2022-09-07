package com.tts.techtalenttwitter.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Tweet {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	// user here  a complex tht can;t be stored in a single data base field. 
	// key to user associate with each tweet.
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name="user_id")
	@OnDelete (action= OnDeleteAction.CASCADE)
	private User user;
	
	
	@NotEmpty(message= "Tweet cannnot be empty")
	@Length(max =280, message = "Tweet cannot have more that 280 characters")
	private String message;
	
	@CreationTimestamp
	private Date createdAt;
	
}
