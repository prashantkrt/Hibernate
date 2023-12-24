package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
	@Column(name="Account_Number")
	private String accountNumber;
	
	@Column(name="Holder_Name")
	private String name;
	
	@Column(name="Account_Type")
	private String accountType;	

}
