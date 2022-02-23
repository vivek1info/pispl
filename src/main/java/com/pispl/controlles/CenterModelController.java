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

import com.pispl.model.Country;
import com.pispl.model.CenterModel;
import com.pispl.model.State;
import com.pispl.services.CenterModelService;

@Controller
public class CenterModelController {

	
	//@GetMapping("/centerModels")
	//public String getCenterModels()
	//{
	//	return "centerModel";
	//}
	
	@Autowired
	private CenterModelService centerModelService;
	
	@GetMapping("/centerModels")
	public String getCenterModels(Model model)
	{			
		List<CenterModel> centerModelList =centerModelService.getCenterModels();	
		model.addAttribute("centerModels",centerModelList);
		return "centerModel";
	}
	@PostMapping("/centerModels/addNew")
	public String addNew(CenterModel centerModel)
	{
		centerModelService.save(centerModel);
		return "redirect:/centerModels";
	}
	@RequestMapping("centerModels/findById")
	@ResponseBody
	public Optional<CenterModel> findById(int id)
	{
		return centerModelService.findById(id);	
	}
	
	@RequestMapping(value="/centerModels/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(CenterModel centerModel)
	{
		centerModelService.save(centerModel);
		return "redirect:/centerModels";
	}
	//delete
	@RequestMapping(value="/centerModels/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		centerModelService.delete(id);
		return "redirect:/centerModels";
	}
}
