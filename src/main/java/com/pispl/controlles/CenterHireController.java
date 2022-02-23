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

import com.pispl.model.CenterHire;
import com.pispl.services.CenterHireService;
import com.pispl.services.CenterService;
import com.pispl.services.ClientService;
import com.pispl.services.LocationService;

@Controller
public class CenterHireController {

	//@GetMapping("/centerHires")
	//public String getCenterHire()
	//{
	//	return "centerhire";
	//}
	
	@Autowired
	private  CenterHireService centerHireService;
	
	@Autowired
	private CenterService centerService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private ClientService clientService;
	
	
	@GetMapping("/centerHires")
	public String getCenterHires(Model model)
	{			
	
		model.addAttribute("centerHires",centerHireService.getCenterHires());
		model.addAttribute("centers",centerService.getCenters());
		model.addAttribute("locations",locationService.getLocations());
		model.addAttribute("clients",clientService.getClients());
		return "centerHire";
	}
	@PostMapping("/centerHires/addNew")
	public String addNew(CenterHire centerHire)
	{
		centerHireService.save(centerHire);
		return "redirect:/centerHires";
	}
	@RequestMapping("centerHires/findById")
	@ResponseBody
	public Optional<CenterHire> findById(int id)
	{
		return centerHireService.findById(id);	
	}
	
	@RequestMapping(value="/centerHires/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(CenterHire centerHire)
	{
		centerHireService.save(centerHire);
		return "redirect:/centerHires";
	}
	//delete
	@RequestMapping(value="/centerHires/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		centerHireService.delete(id);
		return "redirect:/centerHires";
	}	
}
