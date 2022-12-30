package com.example.demo.entitiy;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "user_tb")
@Entity
public class UserEntity implements Serializable{
	

	    @Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "upn")
	    private String upn;
	    
	    @Column(name = "password")
	    private String password;
	}

//
