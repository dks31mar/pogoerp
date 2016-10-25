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
	UserEmployeeDao userEmpdao;

	@Override
	public void adduserEmp(UserEmployeeBean userDTO) throws ParseException 
	{
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy");
		UserEmployee emp=new UserEmployee();
		emp.setLoginname(userDTO.getLoginname());
		emp.setFirstname(userDTO.getFirstname());
		emp.setLastname(userDTO.getLastname());
		emp.setDivision(userDTO.getDivision());
		emp.setRegion(userDTO.getRegion());
		emp.setDateofjoining(dateformat.parse(userDTO.getDateofjoining()));
		emp.setAddress(userDTO.getAddress());
		//emp.setDob(userDTO.getDob());
		emp.setDob(dateformat.parse(userDTO.getDob()));
		emp.setEamil(userDTO.getEamil());
		emp.setBranch(userDTO.getBranch());
		emp.setDesignation(userDTO.getDesignation());
		emp.setGender(userDTO.getGender());
		emp.setPhone(userDTO.getPhone());
		emp.setUsermobile(userDTO.getUsermobile());
		
		emp.setPassword(userDTO.getPassword());
		emp.setRepassword(userDTO.getRepassword());
		
		userEmpdao.addUser(emp);
		
	}

	@Override
	public UserEmployeeBean getUserById(int  userId) 
	{
		UserEmployeeBean userDTO = new UserEmployeeBean();
			
		return null;
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
	public void deleteRecord(int id) {
		UserEmployee emp = userEmpdao.getUserId(id);
		System.out.println("Id"+emp);
		//emp.setActive(false);
		
	}

}
