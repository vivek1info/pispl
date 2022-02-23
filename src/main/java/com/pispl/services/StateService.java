package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.State;
import com.pispl.repositories.StateRepository;

@Service
public class StateService {
	@Autowired
	private StateRepository stateRepository;
	
	//Return list of States
	public List<State> getStates()
	{
		return stateRepository.findAll();
	}
	
	// Save new State
	public void save(State state)
	{
		stateRepository.save(state);
	}
	
	//get by id
	public Optional<State> findById(int id)
	{
		return stateRepository.findById(id);
	}

	public void delete(Integer id) {
		stateRepository.deleteById(id);
		
	}
}
