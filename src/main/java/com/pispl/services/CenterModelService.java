package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.CenterModel;
import com.pispl.repositories.CenterModelRepository;

@Service
public class CenterModelService {

	@Autowired
	private CenterModelRepository centerModelRepository;
	
	//Return list of CenterModels
	public List<CenterModel> getCenterModels()
	{
		return centerModelRepository.findAll();
	}
	
	// Save new CenterModel
	public void save(CenterModel centerModel)
	{
		centerModelRepository.save(centerModel);
	}
	
	//get by id
	public Optional<CenterModel> findById(int id)
	{
		return centerModelRepository.findById(id);
	}

	public void delete(Integer id) {
		centerModelRepository.deleteById(id);
		
	}
}
