package com.pogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerPOController {
	@RequestMapping(value="getCustomerPo", method=RequestMethod.GET)
	public String getcusPo(Model model)
	{
		
		
		return "getCustomerPo";
	}


}
