package com.pogo.serviceImp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.bean.PogoMenuOptionsBean;
import com.pogo.bean.UserBean;
import com.pogo.dao.LoginDao;
import com.pogo.model.PogoMenuOptions;
import com.pogo.model.User;
import com.pogo.service.LoginService;

@Service("loginService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImp implements LoginService{

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public boolean isValid(UserBean userBean,HttpServletRequest request) {
		User user=new User();
		user.setPassword(userBean.getPassword());
		user.setUserName(userBean.getUserName());
		return loginDao.isValidUser(user,request);
		}

	
	@Override
	public Map<String, Object> getLeftMenu(HttpServletRequest request,int id,PogoMenuOptions pmob) {
		
		Map<String, Object> getFirstLevel=loginDao.getLeftMenuData(request,id,pmob); 
		return getFirstLevel;
	}
	

	
}
