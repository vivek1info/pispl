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

import com.pispl.model.CenterMaintainence;
import com.pispl.services.CenterMaintainenceService;
import com.pispl.services.CenterService;
import com.pispl.services.SupplierService;


@Controller
public class CenterMaintainenceController {

	//@GetMapping("/centermaintainences")
	//public String getCenterMaintainence()
	//{
	//	return "centermaintainence";
	//}
	
	
	@Autowired
	private CenterMaintainenceService centerMaintainenceService;
	
	@Autowired
	private CenterService centerService;
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/centerMaintainences")
	public String getCenterMaintainences(Model model)
	{
		
		model.addAttribute("centerMaintainences",centerMaintainenceService.getCenterMaintainences());
			
		model.addAttribute("centers",centerService.getCenters());
		model.addAttribute("suppliers",supplierService.getSuppliers());

		
		return "centerMaintainence";
	}
	@PostMapping("/centerMaintainences/addNew")
	public String addNew(CenterMaintainence centerMaintainence)
	{
		centerMaintainenceService.save(centerMaintainence);
		return "redirect:/centerMaintainences";
	}
	@RequestMapping("centerMaintainences/findById")
	@ResponseBody
	public Optional<CenterMaintainence> findById(int id)
	{
		return centerMaintainenceService.findById(id);	
	}
	
	@RequestMapping(value="/centerMaintainences/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(CenterMaintainence centerMaintainence)
	{
		centerMaintainenceService.save(centerMaintainence);
		return "redirect:/centerMaintainences";
	}
	//delete
	@RequestMapping(value="/centerMaintainences/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		centerMaintainenceService.delete(id);
		return "redirect:/centerMaintainences";
	}	
	
	
}
