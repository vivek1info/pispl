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


import com.pispl.model.Center;

import com.pispl.services.EmployeeService;
import com.pispl.services.LocationService;
import com.pispl.services.CenterMakeService;
import com.pispl.services.CenterService;
import com.pispl.services.CenterStatusService;
import com.pispl.services.CenterTypeService;

@Controller
public class CenterController {

	//Centers
	//Location
	//Employee
	//Center Make
	//Center Status
	//Center Type
	//Center Model
	
	@Autowired
	private CenterService centerService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CenterMakeService centerMakeService;
	
	@Autowired
	private CenterStatusService centerStatusService;
	
	@Autowired
	private CenterTypeService centerTypeService;
	
	//@Autowired
	//private CenterModelService centerModelService;
	
	@GetMapping("/centers")
	public String getCenters(Model model)
	{
		model.addAttribute("centers",centerService.getCenters());
		model.addAttribute("locations",locationService.getLocations());
		model.addAttribute("employees",employeeService.getEmployees());
		model.addAttribute("centerMakes",centerMakeService.getCenterMakes());
		model.addAttribute("centerTypes",centerTypeService.getCenterTypes());
		model.addAttribute("centerStatuses",centerStatusService.getCenterStatuses());
	//	model.addAttribute("centerModels",centerModelService.getCenterModels());
	
		return "center";
	}
	@PostMapping("/centers/addNew")
	public String addNew(Center center)
	{
		centerService.save(center);
		return "redirect:/centers";
	}
	@RequestMapping("centers/findById")
	@ResponseBody
	public Optional<Center> findById(int id)
	{
		return centerService.findById(id);	
	}
	
	@RequestMapping(value="/centers/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Center center)
	{
		centerService.save(center);
		return "redirect:/centers";
	}
	//delete
	@RequestMapping(value="/centers/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		centerService.delete(id);
		return "redirect:/centers";
	}	
}
