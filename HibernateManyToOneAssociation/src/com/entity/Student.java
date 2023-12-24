package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	private String studentName;
	private String city;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Branch branch;


	public Student(String studentName, String city, Branch branch) {
		super();
		this.studentName = studentName;
		this.city = city;
		this.branch = branch;
	}
	
}
