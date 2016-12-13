package com.pogo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pogo.bean.UserBean;
import com.pogo.model.PogoMenuOptions;
import com.pogo.service.LoginService;

@Controller
public class LoginController {
	

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = {"/login","/homep"}, method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView login(@ModelAttribute("command") UserBean userBean,@RequestParam("username") String name,@RequestParam("password") String pass,HttpServletRequest request,PogoMenuOptions pmob) {
		
		userBean.setUserName(name);
		userBean.setPassword(pass);
		System.out.println("asjkdskajdhsakjdhskjdhsakjdhasdmnbiunnskadbuioasdasdhsodasdjoias");
		System.out.println(userBean.getUserName());
		if(loginService.isValid(userBean,request)){
			HttpSession session=request.getSession();
			
			int id=(int)session.getAttribute("userid");
			Map<String, Object> getLeftMenuList=new HashMap<String, Object>();
			getLeftMenuList=loginService.getLeftMenu(request,id,pmob);
			List<String> getLeftMenuList1=new ArrayList<String>();
			 ModelAndView model = new ModelAndView("MainPage");
			 model.addObject("lists", getLeftMenuList);
			 System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&      "+getLeftMenuList);
			 System.out.println("submenu>>>>>>>>>>>>>>>>>>>>>>               "+getLeftMenuList1);
			 System.out.println("ID*************************** "+id);
			return model;
			
			}
		return new ModelAndView("redirect:/LoginPage.jsp");
		}
	
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request,PogoMenuOptions pmob) {
		ModelAndView model=null;
		Map<String, Object> getLeftMenuList=new HashMap<String, Object>();
		int id=0;
		try{
		HttpSession session=request.getSession();
		id=(int)session.getAttribute("userid");
		
		getLeftMenuList=loginService.getLeftMenu(request,id,pmob);
		
		model = new ModelAndView("MainPage");
		 model.addObject("lists", getLeftMenuList);
		}catch(Exception e){
			return new ModelAndView("redirect:/LoginPage.jsp");
		}
		 System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&      "+getLeftMenuList);
		 System.out.println("ID*************************** "+id);
		return model;
		}
}
