package com.pispl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Center {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	private String name;
	@ManyToOne
	@JoinColumn(name="centertypeid", insertable=false, updatable=false)
	private CenterType centerType;
	private Integer centertypeid;	
	
	private String centerNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date acquisitionDate;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="centermakeid", insertable=false, updatable=false)
	private CenterMake centerMake;
	private Integer centermakeid;
	
	private String power;
	private String fuelCapacity;
	@ManyToOne
	@JoinColumn(name="centerstatusid", insertable=false, updatable=false)
	private CenterStatus centerStatus;
	private Integer centerstatusid;	
	
	private String netWeight;

	@ManyToOne
	@JoinColumn(name="employeeid", insertable=false, updatable=false)
	private Employee inCharge;
	private Integer employeeid;
	
	@ManyToOne
	@JoinColumn(name="centermodelid", insertable=false, updatable=false)
	private CenterModel centerModel;	
	private Integer centermodelid;

	@ManyToOne
	@JoinColumn(name="locationid", insertable=false, updatable=false)	
	private Location currentLocation;
	private Integer locationid;
	
	private String remarks;	
}
