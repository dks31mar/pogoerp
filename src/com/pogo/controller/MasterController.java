package com.pogo.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pogo.bean.UserEmployeeBean;

import com.pogo.model.UserEmployee;
import com.pogo.model.Zones;
import com.pogo.service.RegionService;
import com.pogo.service.UserEmployeeService;
@Controller
public class MasterController 
{
	@Autowired
	UserEmployeeService userEmployeeservice;
	@Autowired
	private RegionService regionService;
	
	@RequestMapping(value="/getuseremp",method = RequestMethod.GET)
	
	public ModelAndView getUserEmp(UserEmployee userEmployee,
			HttpServletRequest request)
	{
	List<UserEmployeeBean> list=new ArrayList<UserEmployeeBean>();
	list=userEmployeeservice.getUserDetails();
	Map<String, Object> model= new HashMap<String,Object>();
	model.put("userlist", list);
	
		return new ModelAndView("getuseremp",model);
}
	//for add employee
	@RequestMapping(value = "/saveuserEmp", method = RequestMethod.POST) 
	public String saveDetails(Model model,
			@ModelAttribute("userbean") UserEmployeeBean userDTO) throws ParseException
	{
		userEmployeeservice.adduserEmp(userDTO);
		return "redirect:getuseremp";

	}
	
	// for Edit data fetch
	@RequestMapping(value = "/editUserdetails", method = RequestMethod.GET)
	public String editCity(@RequestParam("id") Integer id, Model model,
			HttpServletRequest request) {
		model.addAttribute("cityDTO", new UserEmployeeBean());
		UserEmployeeBean cityDTO = userEmployeeservice.getUserById(id);
		//model.addAttribute("cityName", cityDTO.getCityName());
		
		model.addAttribute("id", id);
		
		return "updatecity";
	}
	@RequestMapping(value="deleteuserRecord" ,method=RequestMethod.GET)
	public String deleteData(@RequestParam int id) 
	{
		userEmployeeservice.deleteRecord(id);
		return "redirect:useremployee.html";
		}
	
	
	
}