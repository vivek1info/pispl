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

import com.pispl.model.CenterMovement;
import com.pispl.services.CenterMovementService;
import com.pispl.services.CenterService;
import com.pispl.services.LocationService;


@Controller
public class CenterMovementController {

	@Autowired
	private CenterMovementService centerMovementService;
	
	@Autowired
	private CenterService centerService;
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/centerMovements")
	public String getCenterMovements(Model model)
	{
		
		model.addAttribute("centerMovements",centerMovementService.getCenterMovements());
			
		model.addAttribute("centers",centerService.getCenters());
		model.addAttribute("locations",locationService.getLocations());

		
		return "centerMovement";
	}
	@PostMapping("/centerMovements/addNew")
	public String addNew(CenterMovement centerMovement)
	{
		centerMovementService.save(centerMovement);
		return "redirect:/centerMovements";
	}
	@RequestMapping("centerMovements/findById")
	@ResponseBody
	public Optional<CenterMovement> findById(int id)
	{
		return centerMovementService.findById(id);	
	}
	
	@RequestMapping(value="/centerMovements/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(CenterMovement centerMovement)
	{
		centerMovementService.save(centerMovement);
		return "redirect:/centerMovements";
	}
	//delete
	@RequestMapping(value="/centerMovements/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		centerMovementService.delete(id);
		return "redirect:/centerMovements";
	}	
	
	
}
