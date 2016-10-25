package com.pogo.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pogo.bean.PogoMenuOptionsBean;
import com.pogo.bean.UserBean;
import com.pogo.model.PogoMenuOptions;

public interface LoginService {
	public boolean isValid(UserBean userBean, HttpServletRequest request);
	Map<String, Object> getLeftMenu(HttpServletRequest request, int id,PogoMenuOptions pmob);
	

}
