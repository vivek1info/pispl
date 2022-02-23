package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.Country;
import com.pispl.repositories.CountryRepository;

@Service
public class CountryService {
     
	@Autowired
	private CountryRepository countryRepository;
	
	//Return list of Country
	public List<Country> getCountries()
	{
		return countryRepository.findAll();
	}
	
	// Save new Country
	public void save(Country country)
	{
		countryRepository.save(country);
	}
	
	//get by id
	public Optional<Country> findById(int id)
	{
		return countryRepository.findById(id);
	}

	public void delete(Integer id) {
		countryRepository.deleteById(id);
		
	}
}
