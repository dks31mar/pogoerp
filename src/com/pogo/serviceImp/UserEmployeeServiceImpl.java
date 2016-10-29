package com.pogo.serviceImp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.text.SimpleDateFormat;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.dao.UserEmployeeDao;
import com.pogo.model.UserEmployee;
import com.pogo.service.UserEmployeeService;
@Service("userEmployeeService")
@Transactional
public class UserEmployeeServiceImpl implements UserEmployeeService
{
	@Autowired
	private UserEmployeeDao userEmpdao;

	@Override
	public void adduserEmp(UserEmployeeBean userDTO) throws ParseException 
	{
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");
		UserEmployee emp=new UserEmployee();
		emp.setLoginname(userDTO.getLoginname());
		emp.setFirstname(userDTO.getFirstname());
		emp.setLastname(userDTO.getLastname());
		emp.setDivision(userDTO.getDivision());
		emp.setRegion(userDTO.getRegion());
		//emp.setDateofjoining(dateformat.parse(userDTO.getDateofjoining()));
		emp.setAddress(userDTO.getAddress());
		//emp.setDob(dateformat.parse(userDTO.getDob()));
		emp.setEamil(userDTO.getEamil());
		emp.setBranch(userDTO.getBranch());
		emp.setDesignation(userDTO.getDesignation());
		emp.setGender(userDTO.getGender());
		emp.setPhone(userDTO.getPhone());
		emp.setUsermobile(userDTO.getUsermobile());
		emp.setPassword(userDTO.getPassword());
		emp.setRepassword(userDTO.getRepassword());
		emp.setActive(true);
		userEmpdao.addUser(emp);
		
	}

	@Override
	public List<UserEmployee> getUserById(int userId) 
	{
		List<UserEmployee> emp=userEmpdao.getuserEmpId(userId);
		List<UserEmployeeBean> lists=new ArrayList<UserEmployeeBean>();
		for(UserEmployee data: emp)
		{
			UserEmployeeBean userDTO = new UserEmployeeBean();
			userDTO.setUserempid(data.getUserempid());
			userDTO.setLoginname(data.getLoginname());
			userDTO.setFirstname(data.getFirstname());
			userDTO.setLastname(data.getLastname());
			userDTO.setDesignation(data.getDesignation());
			lists.add(userDTO);
		}
		
		return emp;
	}

	@Override
	public List<UserEmployeeBean> getUserDetails() 
	{
		List<UserEmployee> getdetails =userEmpdao.getuserData();
		List<UserEmployeeBean> lists=new ArrayList<UserEmployeeBean>();
		for(UserEmployee list: getdetails)
		{
			UserEmployeeBean data=new UserEmployeeBean();
			data.setUserempid(list.getUserempid());
			data.setLoginname(list.getLoginname());
			//data.setFirstname(list.getFirstname() + list.getLastname() );
			data.setDesignation(list.getDesignation());
			lists.add(data);
		}
			return lists;
		
	}

	@Override
	public void deleteuserEmp(int id) {
		//System.out.println("before getting id \n"+id);
		UserEmployee user = userEmpdao.getUserById(id);
		//System.out.println("after getting id from db  \n"+user.getUserempid());
		user.setActive(false);
		userEmpdao.updateUser(user);
	}

	@Override
	public List<UserEmployeeBean> getUser(String loginname) 
	{
		List<UserEmployee> list = userEmpdao.searchUser(loginname);
		List<UserEmployeeBean> listbean = new ArrayList<UserEmployeeBean>();
		for (UserEmployee data : list) {
			UserEmployeeBean userData = new UserEmployeeBean();
			userData.setUserempid(data.getUserempid());
			userData.setLoginname(data.getLoginname());
			userData.setDesignation(data.getDesignation());
			
			listbean.add(userData);
		
	}

		return listbean;
	}

	

	

	
	

}
