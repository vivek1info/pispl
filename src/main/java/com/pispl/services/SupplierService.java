package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.Supplier;
import com.pispl.repositories.SupplierRepository;

@Service
public class SupplierService {


	@Autowired
	private SupplierRepository supplierRepository;
	
	//Return list of Suppliers
	public List<Supplier> getSuppliers()
	{
		return supplierRepository.findAll();
	}
	
	// Save new Supplier
	public void save(Supplier supplier)
	{
		supplierRepository.save(supplier);
	}
	
	//get by id
	public Optional<Supplier> findById(int id)
	{
		return supplierRepository.findById(id);
	}

	public void delete(Integer id) {
		supplierRepository.deleteById(id);
		
	}
}
