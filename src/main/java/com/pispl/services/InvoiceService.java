package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.Invoice;
import com.pispl.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	//Return list of Invoices
	public List<Invoice> getInvoices()
	{
		return invoiceRepository.findAll();
	}
	
	// Save new Invoice
	public void save(Invoice invoice)
	{
		invoiceRepository.save(invoice);
	}
	
	//get by id
	public Optional<Invoice> findById(int id)
	{
		return invoiceRepository.findById(id);
	}

	public void delete(Integer id) {
		invoiceRepository.deleteById(id);
		
	}
}
