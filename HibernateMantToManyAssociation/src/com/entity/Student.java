package com.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String city;
	private Integer age;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Course> course;

	public Student(String name, String city, Integer age, Set<Course> course) {	
		this.name = name;
		this.city = city;
		this.age = age;
		this.course = course;
	}
}
