package com.pispl.controlles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pispl.model.Country;
import com.pispl.model.State;
import com.pispl.services.CountryService;
import com.pispl.services.StateService;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/states")
	public String getStates(Model model)
	{
		List<State> stateList =stateService.getStates();
		model.addAttribute("states",stateList);
		
		List<Country> countryList =countryService.getCountries();	
		model.addAttribute("countries",countryList);
			
		return "state";
	}
	@PostMapping("/states/addNew")
	public String addNew(State state)
	{
		stateService.save(state);
		return "redirect:/states";
	}
	@RequestMapping("states/findById")
	@ResponseBody
	public Optional<State> findById(int id)
	{
		return stateService.findById(id);	
	}
	
	@RequestMapping(value="/states/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(State state)
	{
		stateService.save(state);
		return "redirect:/states";
	}
	//delete
	@RequestMapping(value="/states/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		stateService.delete(id);
		return "redirect:/states";
	}	
}
