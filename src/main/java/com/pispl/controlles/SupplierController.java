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

import com.pispl.model.Supplier;
import com.pispl.services.SupplierService;
import com.pispl.services.CountryService;
import com.pispl.services.StateService;

@Controller
public class SupplierController {

	
	//@GetMapping("/supplier")
	//public String getSupplier()
	//{
	//	return "supplier";
	//}
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;	
	
	@GetMapping("/suppliers")
	public String getSuppliers(Model model)
	{
		
		model.addAttribute("suppliers",supplierService.getSuppliers());
			
		model.addAttribute("countries",countryService.getCountries());
		
		model.addAttribute("states",stateService.getStates());
		
		return "supplier";
	}
	@PostMapping("/suppliers/addNew")
	public String addNew(Supplier supplier)
	{
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}
	@RequestMapping("suppliers/findById")
	@ResponseBody
	public Optional<Supplier> findById(int id)
	{
		return supplierService.findById(id);	
	}
	
	@RequestMapping(value="/suppliers/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Supplier supplier)
	{
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}
	//delete
	@RequestMapping(value="/suppliers/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		supplierService.delete(id);
		return "redirect:/suppliers";
	}	
	
}
