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

import com.pispl.model.InvoiceStatus;

import com.pispl.services.InvoiceStatusService;


@Controller
public class InvoiceStatusController {

	
	//@GetMapping("/invoiecstatus")
	//public String getInvoiecStatus()
	//{
	//	return "invoiecstatus";
   //	}
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@GetMapping("invoiceStatuses")
	public String findAll(Model model){		
		model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatuses());
		return "invoiceStatus";
	}
	@PostMapping("/invoiceStatuses/addNew")
	public String addNew(InvoiceStatus invoiceStatus)
	{
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	@RequestMapping("invoiceStatuses/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id)
	{
		return invoiceStatusService.findById(id);	
	}
	
	@RequestMapping(value="/invoiceStatuses/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus)
	{
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	//delete
	@RequestMapping(value="/invoiceStatuses/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		invoiceStatusService.delete(id);
		return "redirect:/invoiceStatuses";
	}	
}
