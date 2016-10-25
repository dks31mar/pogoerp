package com.pogo.service;

import java.util.List;
import java.util.Map;


public interface HomePageService {

	List<String> getMenuOfSubMenu(int id,String menuName);

	Map<String, String> getMenuOfSubMenu1(int id, String menuName);
	/*JsonArray getMenuOfSubMenu1(int id, String menuName);*/

	//List<String> getSubMenu();

	

	
}
