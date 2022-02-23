package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.CenterMovement;
import com.pispl.repositories.CenterMovementRepository;

@Service
public class CenterMovementService {

	

	@Autowired
	private CenterMovementRepository centerMovementRepository;
	
	//Return list of CenterMovements
	public List<CenterMovement> getCenterMovements()
	{
		return centerMovementRepository.findAll();
	}
	
	// Save new CenterMovement
	public void save(CenterMovement centerMovement)
	{
		centerMovementRepository.save(centerMovement);
	}
	
	//get by id
	public Optional<CenterMovement> findById(int id)
	{
		return centerMovementRepository.findById(id);
	}

	public void delete(Integer id) {
		centerMovementRepository.deleteById(id);
		
	}
}
