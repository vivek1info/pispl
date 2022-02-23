package com.pispl.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	private String othername;
	private String title;
	private String initials;
	private String socialSecurityNumber;
	private String maritalStatus;
	
	@ManyToOne
	@JoinColumn(name="countryid", insertable=false,updatable=false)
	private Country country;
	private int countryid;
	
	@ManyToOne
	@JoinColumn(name="stateid", insertable=false,updatable=false)
	private State state;
	private int stateid;
	
	@DateTimeFormat(pattern ="yyyy-mm-dd")
	private Date dateofBirth;
	private String city;
	private String address;
	private String phone;
	private String email;
	private String photo;
}
