package com.pispl.controlles;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.pispl.model.Client;
import com.pispl.services.CountryService;
import com.pispl.services.StateService;
import com.pispl.services.ClientService;

@Controller
public class ClientController {

	
	//@GetMapping("/client")
	//public String getClient()
	//{
	//	return "client";
	//}
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;	
	
	@GetMapping("/clients")
	public String getClients(Model model)
	{
		
		model.addAttribute("clients",clientService.getClients());
			
		model.addAttribute("countries",countryService.getCountries());
		
		model.addAttribute("states",stateService.getStates());
		
		return "client";
	}
	@PostMapping("/clients/addNew")
	public String addNew(Client client)
	{
		clientService.save(client);
		return "redirect:/clients";
	}
	@RequestMapping("clients/findById")
	@ResponseBody
	public Optional<Client> findById(int id)
	{
		return clientService.findById(id);	
	}
	
	@RequestMapping(value="/clients/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Client client)
	{
		clientService.save(client);
		return "redirect:/clients";
	}
	//delete
	@RequestMapping(value="/clients/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		clientService.delete(id);
		return "redirect:/clients";
	}	
	
	
}
