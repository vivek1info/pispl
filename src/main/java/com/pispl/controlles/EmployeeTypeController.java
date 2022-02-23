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


import com.pispl.model.EmployeeType;
import com.pispl.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {

	
	//@GetMapping("/employeetype")
	//public String getEmployeeType()
	//{
	//	return "employeetype";
	//}
	
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@GetMapping("/employeeTypes")
	public String getEmployeeTypes(Model model)
	{			
		List<EmployeeType> employeeTypeList =employeeTypeService.getEmployeeTypes();	
		model.addAttribute("employeeTypes",employeeTypeList);
		return "employeeType";
	}
	@PostMapping("/employeeTypes/addNew")
	public String addNew(EmployeeType employeeType)
	{
		employeeTypeService.save(employeeType);
		return "redirect:/employeeTypes";
	}
	@RequestMapping("employeeTypes/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(int id)
	{
		return employeeTypeService.findById(id);	
	}
	
	@RequestMapping(value="/employeeTypes/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(EmployeeType employeeType)
	{
		employeeTypeService.save(employeeType);
		return "redirect:/employeeTypes";
	}
	//delete
	@RequestMapping(value="/employeeTypes/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		employeeTypeService.delete(id);
		return "redirect:/employeeTypes";
	}	
}
