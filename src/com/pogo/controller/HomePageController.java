package com.pogo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.pogo.service.HomePageService;
@Controller
public class HomePageController {
	
	@Autowired
	private HomePageService homePageService;
	@Transactional
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logOut(HttpServletRequest request) {
		
		HttpSession session1 = request.getSession();
		int id=(int)session1.getAttribute("userid");
		session1.removeAttribute("username");
		System.out.println(id);
		
		session1.invalidate();
		
		System.out.println("remove");
		System.out.println(">>>>>>>>>>>>>    "+id);
		return new ModelAndView("logout");
		}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/getsubmenu2", method = RequestMethod.GET)
	
	public void getSubMenu2(HttpServletRequest request,@RequestParam("select") String menuName,HttpServletResponse res) {
		HttpSession session=request.getSession();
		int id=(int)session.getAttribute("userid");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		Map<String, String> getLeftMenuList=homePageService.getMenuOfSubMenu1(id,menuName);
		/*JsonArray getLeftMenuList=homePageService.getMenuOfSubMenu1(id,menuName);*/
		JsonObject obj = new JsonObject();
		System.out.println("listtttt               "+getLeftMenuList);
		try {
			res.getWriter().print(getLeftMenuList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}
}