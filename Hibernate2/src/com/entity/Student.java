package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

	@Id  //for primary key
	@Column(name = "ID")
	private Integer id;
	@Column(name = "Name")
	private String name;
	@Column(name = "City")
	private String city;
	@Column(name = "Age")
	private Integer age;

}
