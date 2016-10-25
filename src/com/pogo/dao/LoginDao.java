package com.pogo.dao;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pogo.bean.UserBean;
import com.pogo.model.PogoMenuOptions;
import com.pogo.model.User;

public interface LoginDao {
	public boolean isValidUser(User user, HttpServletRequest request);
	Map<String, Object> getLeftMenuData(HttpServletRequest request, int id,PogoMenuOptions pmob);
	
	
}
