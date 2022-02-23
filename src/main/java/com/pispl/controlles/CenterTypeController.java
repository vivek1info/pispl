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


import com.pispl.model.CenterType;
import com.pispl.services.CenterTypeService;

@Controller
public class CenterTypeController {

	
	//@GetMapping("/centertype")
	//public String getCenterType()
	//{
	//	return "centertype";
	//}
	
	@Autowired
	private CenterTypeService centerTypeService;
	
	@GetMapping("/centerTypes")
	public String getCenterTypes(Model model)
	{			
		List<CenterType> centerTypeList =centerTypeService.getCenterTypes();	
		model.addAttribute("centerTypes",centerTypeList);
		return "centerType";
	}
	@PostMapping("/centerTypes/addNew")
	public String addNew(CenterType centerType)
	{
		centerTypeService.save(centerType);
		return "redirect:/centerTypes";
	}
	@RequestMapping("centerTypes/findById")
	@ResponseBody
	public Optional<CenterType> findById(int id)
	{
		return centerTypeService.findById(id);	
	}
	
	@RequestMapping(value="/centerTypes/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(CenterType centerType)
	{
		centerTypeService.save(centerType);
		return "redirect:/centerTypes";
	}
	//delete
	@RequestMapping(value="/centerTypes/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		centerTypeService.delete(id);
		return "redirect:/centerTypes";
	}	
}
