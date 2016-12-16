package com.pogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CollectionController {
	@RequestMapping(value="addcollection", method=RequestMethod.GET)
	public ModelAndView addcollection()
	{
		return new ModelAndView("addcollection"); 
	}

	@RequestMapping(value="pendinlist", method=RequestMethod.GET)
	public ModelAndView pendinglist()
	{
		return new ModelAndView("pendinlist"); 
	}

}
