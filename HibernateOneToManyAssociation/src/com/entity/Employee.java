package com.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;

	private String name;

	private Double salary;

	private String city;	
	

	public Employee(String name, Double salary, String city) {
		super();	
		this.name = name;
		this.salary = salary;
		this.city = city;
	}

}
