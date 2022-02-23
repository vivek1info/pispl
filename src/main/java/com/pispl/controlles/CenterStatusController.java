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


import com.pispl.model.CenterStatus;
import com.pispl.services.CenterStatusService;

@Controller
public class CenterStatusController {

	
	//@GetMapping("/centerstatus")
	//public String getCenterStatus()
	//{
	//	return "centerstatus";
	//}
	
	@Autowired
	private CenterStatusService centerStatusService;
	
	@GetMapping("/centerStatuses")
	public String getCenterStatuses(Model model)
	{			
		List<CenterStatus> centerStatusList =centerStatusService.getCenterStatuses();	
		model.addAttribute("centerStatuses",centerStatusList);
		return "centerStatus";
	}
	@PostMapping("/centerStatuses/addNew")
	public String addNew(CenterStatus centerStatus)
	{
		centerStatusService.save(centerStatus);
		return "redirect:/centerStatuses";
	}
	@RequestMapping("centerStatuss/findById")
	@ResponseBody
	public Optional<CenterStatus> findById(int id)
	{
		return centerStatusService.findById(id);	
	}
	
	@RequestMapping(value="/centerStatuss/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(CenterStatus centerStatus)
	{
		centerStatusService.save(centerStatus);
		return "redirect:/centerStatuss";
	}
	//delete
	@RequestMapping(value="/centerStatuss/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		centerStatusService.delete(id);
		return "redirect:/centerStatuss";
	}	
}
