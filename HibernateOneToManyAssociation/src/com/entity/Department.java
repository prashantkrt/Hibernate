package com.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Department {

	@Id		
	private String departmentId;	
	private String departmentName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Employee> employee;

	public Department() {
		super();
		System.out.println("Department constructor for Hibernate");
	}	

	public Department(String departmentId, String departmentName, Set<Employee> employee) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employee = employee;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employee="
				+ employee + "]";
	}

}
