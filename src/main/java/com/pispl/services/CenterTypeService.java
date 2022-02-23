package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.CenterType;
import com.pispl.repositories.CenterTypeRepository;

@Service
public class CenterTypeService {

	@Autowired
	private CenterTypeRepository centerTypeRepository;
	
	//Return list of CenterTypes
	public List<CenterType> getCenterTypes()
	{
		return centerTypeRepository.findAll();
	}
	
	// Save new CenterType
	public void save(CenterType centerType)
	{
		centerTypeRepository.save(centerType);
	}
	
	//get by id
	public Optional<CenterType> findById(int id)
	{
		return centerTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		centerTypeRepository.deleteById(id);
		
	}
}
