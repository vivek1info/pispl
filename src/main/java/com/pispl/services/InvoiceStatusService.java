package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.InvoiceStatus;
import com.pispl.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {

	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	//Return list of InvoiceStatuss
	public List<InvoiceStatus> getInvoiceStatuses()
	{
		return invoiceStatusRepository.findAll();
	}
	
	// Save new InvoiceStatus
	public void save(InvoiceStatus invoiceStatus)
	{
		invoiceStatusRepository.save(invoiceStatus);
	}
	
	//get by id
	public Optional<InvoiceStatus> findById(int id)
	{
		return invoiceStatusRepository.findById(id);
	}

	public void delete(Integer id) {
		invoiceStatusRepository.deleteById(id);
		
	}
}
