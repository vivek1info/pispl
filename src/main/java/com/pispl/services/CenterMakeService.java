package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.CenterMake;
import com.pispl.repositories.CenterMakeRepository;

@Service
public class CenterMakeService {

	@Autowired
	private CenterMakeRepository centerMakeRepository;
	
	//Return list of CenterMakes
	public List<CenterMake> getCenterMakes()
	{
		return centerMakeRepository.findAll();
	}
	
	// Save new CenterMake
	public void save(CenterMake centerMake)
	{
		centerMakeRepository.save(centerMake);
	}
	
	//get by id
	public Optional<CenterMake> findById(int id)
	{
		return centerMakeRepository.findById(id);
	}

	public void delete(Integer id) {
		centerMakeRepository.deleteById(id);
		
	}
}
