package com.pogo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.UserEmployeeBean;
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
	@RequestMapping(value="/Editregion",method = RequestMethod.GET)
	public ModelAndView editZones(@RequestParam("id") Integer id,Zones porefitem,HttpServletRequest request,Model model)
			{
	    List<Zones> getbranch=new ArrayList<Zones>();
	    model.addAttribute("getregion", regionService.editZones(id));
		getbranch=regionService.getBranches();
		Map<String, Object> mode = new HashMap<String, Object>();
		mode.put("branchList",  getbranch);
		return new ModelAndView("editregion",mode);
}
	@RequestMapping(value="/branches",method = RequestMethod.GET)
	public ModelAndView getStates(Zones porefitem,HttpServletRequest request){
	
		List<Zones> getStates=new ArrayList<Zones>();
		getStates=regionService.getStates();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("branchList",  getStates);
		return new ModelAndView("branches",model);
	
}
	@RequestMapping(value = "/update-region", method = RequestMethod.POST)
	public String updateregion(@ModelAttribute("zonesBean")  ZonesBean zonesBean)  {
		regionService.updateregion(zonesBean);
		System.out.println("i am here");
		return "redirect:/region";
	
	}
@RequestMapping(value="/deleteRegion",method=RequestMethod.GET)
public String deleteRegionData(@RequestParam ("id")int id)
{
	regionService.deleteRegion(id);
	return "redirect:/region";
	
}
@RequestMapping(value="/addstates",method = RequestMethod.GET)
public ModelAndView getSouthBranch(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){

	//commonservice.getPoRefNo(request);

return new ModelAndView("addstates");
}	
}
