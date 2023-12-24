package com.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="StudentTable")
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
