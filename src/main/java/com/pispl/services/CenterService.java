package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.Center;
import com.pispl.repositories.CenterRepository;


@Service
public class CenterService {

	@Autowired
	private CenterRepository centerRepository;
	
	//Return list of Suppliers
	//public List<Center> getCenters()
	//{
	//	return centerRepository.findAll();
	//}
	
	
	//Return list of Centers
	public List<Center> getCenters()
	{
		return centerRepository.findAll();
	}
	
	// Save new Center
	public void save(Center center)
	{
		centerRepository.save(center);
	}
	
	//get by id
	public Optional<Center> findById(int id)
	{
		return centerRepository.findById(id);
	}

	public void delete(Integer id) {
		centerRepository.deleteById(id);
		
	}
}
