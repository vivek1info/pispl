package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.CenterHire;
import com.pispl.repositories.CenterHireRepository;

@Service
public class CenterHireService {

	@Autowired
	private CenterHireRepository centerHireRepository;
	
	//Return list of CenterHires
	public List<CenterHire> getCenterHires()
	{
		return centerHireRepository.findAll();
	}
	
	// Save new CenterHire
	public void save(CenterHire centerHire)
	{
		centerHireRepository.save(centerHire);
	}
	
	//get by id
	public Optional<CenterHire> findById(int id)
	{
		return centerHireRepository.findById(id);
	}

	public void delete(Integer id) {
		centerHireRepository.deleteById(id);
		
	}
}
