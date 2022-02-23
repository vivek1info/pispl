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

import com.pispl.model.Employee;
import com.pispl.services.CountryService;

import com.pispl.services.EmployeeService;

import com.pispl.services.EmployeeTypeService;
import com.pispl.services.JobTitleService;
import com.pispl.services.StateService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JobTitleService jobTitleService;
	
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	//@Autowired
	//private EmployeeTypeService employeeTypeService;
	
	//@Autowired
	//private EmployeeModelService employeeModelService;
	
	@GetMapping("/employees")
	public String getEmployees(Model model)
	{

		model.addAttribute("employees",employeeService.getEmployees());
		model.addAttribute("jobTitles",jobTitleService.getJobTitles());
		model.addAttribute("employeeTypes",employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries",countryService.getCountries());
		model.addAttribute("states", stateService.getStates());			
		return "employee";
	}
	@PostMapping("/employees/addNew")
	public String addNew(Employee employee)
	{
		employeeService.save(employee);
		return "redirect:/employees";
	}
	@RequestMapping("employees/findById")
	@ResponseBody
	public Optional<Employee> findById(int id)
	{
		return employeeService.findById(id);	
	}
	
	@RequestMapping(value="/employees/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Employee employee)
	{
		employeeService.save(employee);
		return "redirect:/employees";
	}
	//delete
	@RequestMapping(value="/employees/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		employeeService.delete(id);
		return "redirect:/employees";
	}	
	
}
