package com.pispl.model;

import java.util.Date;

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

public class Invoice {	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date invoiceDate;
	
	@ManyToOne
	@JoinColumn(name="invoicestatusid", insertable=false, updatable=false)	
	private InvoiceStatus invoiceStatus;
	private Integer invoicestatusid;
	
	@ManyToOne
	@JoinColumn(name="clientid", insertable=false, updatable=false)	
	private Client client;
	private Integer clientid;
	
	private String remarks;	
}
