package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.Location;

import com.pispl.repositories.LocationRepository;


@Service
public class LocationService {
	@Autowired
	private LocationRepository locationRepository;
	
	//Return list of Locations
	public List<Location> getLocations()
	{
		return locationRepository.findAll();
	}
	
	// Save new Location
	public void save(Location location)
	{
		locationRepository.save(location);
	}
	
	//get by id
	public Optional<Location> findById(int id)
	{
		return locationRepository.findById(id);
	}

	public void delete(Integer id) {
		locationRepository.deleteById(id);
		
	}
	}

