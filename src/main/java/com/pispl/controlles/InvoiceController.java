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


import com.pispl.model.Invoice;
import com.pispl.services.ClientService;
import com.pispl.services.InvoiceService;
import com.pispl.services.InvoiceStatusService;



@Controller
public class InvoiceController {

	//@GetMapping("/invoiec")
	//public String getInvoiec()
	//{
	//	return "invoiec";
	//}
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/invoices")
	public String getInvoices(Model model)
	{
		model.addAttribute("invoices",invoiceService.getInvoices());
			
		model.addAttribute("clients",clientService.getClients());
		model.addAttribute("invoiceStatuses",invoiceStatusService.getInvoiceStatuses());
		return "invoice";
	}
	@PostMapping("/invoices/addNew")
	public String addNew(Invoice invoice)
	{
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}
	@RequestMapping("invoices/findById")
	@ResponseBody
	public Optional<Invoice> findById(int id)
	{
		return invoiceService.findById(id);	
	}
	
	@RequestMapping(value="/invoices/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Invoice invoice)
	{
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}
	//delete
	@RequestMapping(value="/invoices/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id)
	{
		invoiceService.delete(id);
		return "redirect:/invoices";
	}	
}
