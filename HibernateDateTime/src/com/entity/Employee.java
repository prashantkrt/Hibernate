package com.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Employee2")
public class Employee {

	@Id
	@Column(name = "ID")
	private Integer Id;
	@Column(name = "Name")
	private String name;
	@Column(name = "City")
	private String city;
	@Column(name = "Age")
	private String age;
	
	//to specify that this is a date type dataType
	@Temporal(TemporalType.DATE)
	@Column(name = "Date")
	private Date date;
	
	//to specify that this is a time type dataType
	@Temporal(TemporalType.TIME)
	@Column(name = "Time")
	private Date time;
	
	//to specify that this is a date and Time both type dataType
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateTime")
	private Date dateTime;

	public Employee() {		
		//required for hibernate: mandatory	
	}

	public Employee(Integer id, String name, String city, String age, Date date, Date time, Date dateTime) {
		super();
		Id = id;
		this.name = name;
		this.city = city;
		this.age = age;
		this.date = date;
		this.time = time;
		this.dateTime = dateTime;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", city=" + city + ", age=" + age + ", date=" + date
				+ ", time=" + time + ", dateTime=" + dateTime + "]";
	}

}
