package com.pogo.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

//import com.pogo.service.TestService;
@SuppressWarnings({"rawtypes","unchecked"})
@Controller
public class TestContoller {
	

	@SuppressWarnings("unchecked")
	@RequestMapping("/link1") 
	public ModelAndView linkShow1(){
		ModelAndView model = new ModelAndView("test");
		List list=new ArrayList<>();
		list.add("sdas");
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccccc");
		list.add("dddd");
		list.add("eeee");
		list.add("ffff");
		
		
		model.addObject("list1",list);
		return model;
	}
	@RequestMapping("/login123") 
	public ModelAndView login(){
		ModelAndView model = new ModelAndView("test");
		return model;
	}
	@RequestMapping(value="/link2" , method = {RequestMethod.POST,RequestMethod.GET}) 
	public void linkShow2(HttpServletResponse responce){
		//ModelAndView model = new ModelAndView("test");
		List list1=new ArrayList<>();
		list1.add("shewta");
		list1.add("@@@@@@");
		list1.add("999999");
		list1.add("66666666");
		list1.add("&&&&&&&&");
		list1.add("&*&*&");
		list1.add("9999999");
		
		String json = new Gson().toJson(list1 );
		try {
			responce.getWriter().print(list1);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//model.addObject("list2",json);
		
	}
	
	/*@RequestMapping(value="/test" , method = {RequestMethod.POST,RequestMethod.GET}) 
	public ModelAndView linkS(HttpServletResponse responce){
		ModelAndView model = new ModelAndView("shweta");
		
		return model;
	}*/

}
