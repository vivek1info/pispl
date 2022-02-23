package com.pispl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Location {
   
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	private String description;
	private String details;
	
	@ManyToOne
	@JoinColumn(name="countryid", insertable=false,updatable=false)
	private Country country;
	private int countryid;
	
	@ManyToOne
	@JoinColumn(name="stateid", insertable=false,updatable=false)
	private State state;
	private Integer stateid;
	
	
	private String city;
	private String address;
}
