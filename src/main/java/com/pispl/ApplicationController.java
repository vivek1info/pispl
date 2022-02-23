package com.pispl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
 
	//@GetMapping("/index")
	//public String goHome()
	//{
	//	return "index";
	//}
	
	@GetMapping("/cpannel")
	public String goCPannel()
	{
		return "cpannel";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout()
	{
		return "login";
	}
	@GetMapping("/register")
	public String register()
	{
		return "register";
    }
}