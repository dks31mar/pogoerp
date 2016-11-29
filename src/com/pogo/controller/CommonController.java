package com.pogo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.PorefSupplierDetailBean;
import com.pogo.model.PorefSupplierDetail;
import com.pogo.service.CommonService;

@Controller
public class CommonController {

	
	@Autowired
	private CommonService commonservice;
	
	@RequestMapping(value="/getaddpo",method = RequestMethod.GET)
	public ModelAndView getPage(@ModelAttribute("productadd") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		commonservice.getPoRefNo(request);
	
	return new ModelAndView("AddPrinicpalPO");
			
}

	@RequestMapping(value="/appuser",method = RequestMethod.GET)
	public ModelAndView getUser(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("AppUser");
			
}
	
/*	@RequestMapping(value="/branches",method = RequestMethod.GET)
	public ModelAndView getBranches(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("branches");
			} */
	@RequestMapping(value="/Email",method = RequestMethod.GET)
	public ModelAndView getEmail(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("email");
}
	@RequestMapping(value="/Sms",method = RequestMethod.GET)
	public ModelAndView getSmsAllocation(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("sms");
}
	@RequestMapping(value="/Import",method = RequestMethod.GET)
	public ModelAndView getImportDeb(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("import");
}
	@RequestMapping(value="/Employee",method = RequestMethod.GET)
	public ModelAndView getEmployee(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("employee");
}
	
	
	@RequestMapping(value="/NewBranch",method = RequestMethod.GET)
	public ModelAndView getNewbranch(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("newbranch");
}
	
	@RequestMapping(value="/eastBranch",method = RequestMethod.GET)
	public ModelAndView getEastBranch(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("eastbranch");
}
	@RequestMapping(value="/northbranch",method = RequestMethod.GET)
	public ModelAndView getNorthBranch(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("northbranch");
}
	@RequestMapping(value="/southBranch",method = RequestMethod.GET)
	public ModelAndView getSouthBranch(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("southbranch");
}
	@RequestMapping(value="/westbranch",method = RequestMethod.GET)
	public ModelAndView getWestBranchh(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("westbranch");
}
	@RequestMapping(value="/addemployee",method = RequestMethod.GET)
	public ModelAndView getAddemployee(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("addemployee");
}

	@RequestMapping(value="/editregion",method = RequestMethod.GET)
	public ModelAndView getEditregion(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("Editregion");
	
	}
	@RequestMapping(value="/getzonepage",method = RequestMethod.GET)
	public ModelAndView getAdd(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		//commonservice.getPoRefNo(request);
	
	return new ModelAndView("addregion");
}
	
	

	/**************************************************** use by shweta *****************************************************/
	

	@RequestMapping(value="/supplierinvoice",method = RequestMethod.GET)
	public ModelAndView getsupplierinvoice( @ModelAttribute("command") PorefSupplierDetailBean porefitem,HttpServletRequest request,BindingResult result){
		System.out.println("in get edit method");

	return new ModelAndView("supplierinvoiceview");
	}
	/************************************************** use by shweta ***************************************************/

}
