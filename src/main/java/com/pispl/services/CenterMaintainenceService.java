package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.CenterMaintainence;
import com.pispl.repositories.CenterMaintainenceRepository;

@Service
public class CenterMaintainenceService {

	@Autowired
	private CenterMaintainenceRepository centerMaintainenceRepository;
	
	//Return list of CenterMaintainences
	public List<CenterMaintainence> getCenterMaintainences()
	{
		return centerMaintainenceRepository.findAll();
	}
	
	// Save new CenterMaintainence
	public void save(CenterMaintainence centerMaintainence)
	{
		centerMaintainenceRepository.save(centerMaintainence);
	}
	
	//get by id
	public Optional<CenterMaintainence> findById(int id)
	{
		return centerMaintainenceRepository.findById(id);
	}

	public void delete(Integer id) {
		centerMaintainenceRepository.deleteById(id);
		
	}
}
