package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor // for hibernate requirement
public class Profile {
	
	@Id
	private Integer profileId;
	
	private String name;
	
	@Lob//large objects
	@Column(name ="Image")
	private byte [] img;
	
	
	@Lob
	@Column(name="Document")
	private char [] charFile;
}
