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


import com.pispl.model.CenterMake;
import com.pispl.services.CenterMakeService;

@Controller
public class CenterMakeController {

	
	@Autowired
	private CenterMakeService centerMakeService;
	
	@GetMapping("/centerMakes")
	public String getCenterMakes(Model model)
	{			
		List<CenterMake> centerMakeList =centerMakeService.getCenterMakes();	
		model.addAttribute("centerMakes",centerMakeList);
		return "centerMake";
	}
	@PostMapping("/centerMakes/addNew")
	public String addNew(CenterMake centerMake)
	{
		centerMakeService.save(centerMake);
		return "redirect:/centerMakes";
	}
	@RequestMapping("centerMakes/findById")
	@ResponseBody
	public Optional<CenterMake> findById(int id)
	{
		return centerMakeService.findById(id);	
	}
	
	@RequestMapping(value="/centerMakes/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(CenterMake centerMake)
	{
		centerMakeService.save(centerMake);
		return "redirect:/centerMakes";
	}
	//delete
	@RequestMapping(value="/centerMakes/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		centerMakeService.delete(id);
		return "redirect:/centerMakes";
	}		
}
