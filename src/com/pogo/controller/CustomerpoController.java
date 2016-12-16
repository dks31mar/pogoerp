package com.pogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CustomerpoController {

@RequestMapping(value="createOrder", method=RequestMethod.GET)
	 public ModelAndView  CreateOrder()
	 {
		 return  new ModelAndView("createOrder");
    }

@RequestMapping(value="vieworder", method=RequestMethod.GET)
	 public ModelAndView  viewOrder()
	 {
		 return  new ModelAndView("vieworder");
	 }
}
