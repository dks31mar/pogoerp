package com.pogo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logOut(HttpSession session) {
		String name=(String)session.getAttribute("username");
		System.out.println(name);
		session.invalidate();
		System.out.println("remove");
		System.out.println(">>>>>>>>>>>>>    "+name);
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
		//return null;

	}
}