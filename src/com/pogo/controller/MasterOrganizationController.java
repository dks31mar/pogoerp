package com.pogo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pogo.bean.ZonesBean;
import com.pogo.model.Zones;
import com.pogo.service.MasterOrganizationService;

@Controller
public class MasterOrganizationController {

	
	@Autowired
	private MasterOrganizationService regionService;
	
	
	
	@RequestMapping(value="/region",method = RequestMethod.GET)
	public ModelAndView getRegion(Zones porefitem,HttpServletRequest request){
	
		List<Zones> getbranch=new ArrayList<Zones>();
		getbranch=regionService.getBranches();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("branchList",  getbranch);
		return new ModelAndView("region",model);
		
	}
	
	
	
	@RequestMapping(value="addzonedetails",method=RequestMethod.POST)
	@ResponseBody
	public void addZoneDeatils(@RequestBody String json,Model model) throws IOException{
	System.out.println("Add zone data   \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		ZonesBean poref=mapper.readValue(json, ZonesBean.class);
		
		
		ZonesBean poref1=new ZonesBean();
		
		
		regionService.addZoneDeatils(poref);
		
	}
}
