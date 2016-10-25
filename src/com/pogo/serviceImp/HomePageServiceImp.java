package com.pogo.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.bean.SubMenuBean;
import com.pogo.dao.HomePageDao;
import com.pogo.service.HomePageService;
@SuppressWarnings({ "rawtypes", "unchecked" })
@Service("homePageService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HomePageServiceImp implements HomePageService{

	@Autowired
	private HomePageDao homePageDao;

	
	@Override
	public List<String> getMenuOfSubMenu(int id ,String menuName) {
		List getFirstLevel=homePageDao.getMenuOfSubMenu(id,menuName); 
		return getFirstLevel;
	}


	@Override
	public Map<String, String> getMenuOfSubMenu1(int id, String menuName) {
		List<SubMenuBean> getMenuWithUrl=homePageDao.getSubMenuDetails(id,menuName);
		HashMap<String, String> productMap = new HashMap<String, String>();
		//JsonArray arry = new JsonArray(); 
		if(!getMenuWithUrl.isEmpty()){
		for(SubMenuBean sub: getMenuWithUrl)
		{
			
			productMap.put(sub.getOptiondescription(), "->"+sub.getFormname());
		}
		}
		System.out.println("submenu map***************************************   \n"+productMap);
		return productMap;
	}

	/*@Override
	public JsonArray getMenuOfSubMenu1(int id, String menuName) {
		List<SubMenuBean> getMenuWithUrl=homePageDao.getSubMenuDetails(id,menuName);
		HashMap<String, String> productMap = new HashMap<String, String>();
		JsonArray arry = new JsonArray(); 
		for(SubMenuBean sub: getMenuWithUrl)
		{
			JsonObject obj = new JsonObject();
			obj.addProperty("optionname",sub.getOptiondescription());
			obj.addProperty("url",sub.getFormname());
			arry.add(obj);
			//productMap.put(sub.getOptiondescription(), sub.getFormname());
		}
		System.out.println("submenu map***************************************   \n"+productMap);
		return arry;
	}*/
	
}
