package com.pogo.dao;

import java.util.List;

import com.pogo.bean.SubMenuBean;
@SuppressWarnings("rawtypes")
public interface HomePageDao {

	
	List getMenuOfSubMenu(int id,String menuName);

	List<SubMenuBean> getSubMenuDetails(int id, String menuName);

	/*List getSubMenu();
*/
	

}
