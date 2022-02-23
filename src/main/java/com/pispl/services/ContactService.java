package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.Contact;
import com.pispl.repositories.ContactRepository;

@Service
public class ContactService {

	

	@Autowired
	private ContactRepository contactRepository;
	
	//Return list of Contacts
	public List<Contact> getContacts()
	{
		return contactRepository.findAll();
	}
	
	// Save new Contact
	public void save(Contact contact)
	{
		contactRepository.save(contact);
	}
	
	//get by id
	public Optional<Contact> findById(int id)
	{
		return contactRepository.findById(id);
	}

	public void delete(Integer id) {
		contactRepository.deleteById(id);
		
	}
}
