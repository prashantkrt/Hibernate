package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto in increament
	private Integer id;

	private String name;

	private Double salary;
	
	private String city;

	// anything happens to employee like deleted so this will too be deleted
	// making tightly coupled
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
}
