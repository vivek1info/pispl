package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.CenterStatus;
import com.pispl.repositories.CenterStatusRepository;

@Service
public class CenterStatusService {

	@Autowired
	private CenterStatusRepository centerStatusRepository;
	
	//Return list of CenterStatuss
	public List<CenterStatus> getCenterStatuses()
	{
		return centerStatusRepository.findAll();
	}
	
	// Save new CenterStatus
	public void save(CenterStatus centerStatus)
	{
		centerStatusRepository.save(centerStatus);
	}
	
	//get by id
	public Optional<CenterStatus> findById(int id)
	{
		return centerStatusRepository.findById(id);
	}

	public void delete(Integer id) {
		centerStatusRepository.deleteById(id);
		
	}
}
