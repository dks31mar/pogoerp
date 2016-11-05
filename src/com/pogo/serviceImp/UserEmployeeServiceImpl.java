package com.pogo.serviceImp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.impl.USerializedSet;
import com.ibm.icu.text.SimpleDateFormat;
import com.pogo.bean.DesignationBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.dao.UserEmployeeDao;
import com.pogo.model.Designation;
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
		emp.setDateofjoining(dateformat.parse(userDTO.getDateofjoining()));
		emp.setAddress(userDTO.getAddress());
		emp.setDob(dateformat.parse(userDTO.getDob()));
		emp.setEamil(userDTO.getEamil());
		emp.setBranch(userDTO.getBranch());
		emp.setDesignation(userDTO.getDesignation());
		emp.setGender(userDTO.getGender());
		emp.setPhone(userDTO.getPhone());
		emp.setUsermobile(userDTO.getUsermobile());
		emp.setPassword(userDTO.getPassword());
		emp.setRepassword(userDTO.getRepassword());
		emp.setDepartment(userDTO.getDepartment());
		emp.setEmpCode(userDTO.getEmpCode());
		emp.setMiddlename(userDTO.getMiddlename());
		emp.setSubcompany(userDTO.getSubcompany());
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

	@Override
	public UserEmployeeBean getEmployee(int empid) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");
		UserEmployee empedit = userEmpdao.getEmployee(empid);
		UserEmployeeBean empbean = new UserEmployeeBean();
		empbean.setUserempid(empedit.getUserempid());
		empbean.setLoginname(empedit.getLoginname());
		empbean.setDesignation(empedit.getDesignation());
		empbean.setFirstname(empedit.getFirstname());
		empbean.setLastname(empedit.getLastname());
		empbean.setDivision(empedit.getDivision());
		empbean.setRegion(empedit.getRegion());
		empbean.setDateofjoining(dateformat.format(empedit.getDateofjoining()));
		empbean.setDob(dateformat.format(empedit.getDob()));
	    empbean.setAddress(empedit.getAddress());
		empbean.setEamil(empedit.getEamil());
		empbean.setGender(empedit.getGender());
		empbean.setUsermobile(empedit.getUsermobile());
		empbean.setPhone(empedit.getPhone());
		empbean.setBranch(empedit.getBranch());
		empbean.setPassword(empedit.getPassword());
		empbean.setRepassword(empedit.getRepassword());
		empbean.setMiddlename(empedit.getMiddlename());
		empbean.setDepartment(empedit.getDepartment());
		empbean.setEmpCode(empedit.getEmpCode());
		empbean.setSubcompany(empedit.getSubcompany());
		return empbean;
		
	}
@Transactional
	@Override
	public void updateEmployee(UserEmployeeBean userEmployeeBean) throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");
		UserEmployee emp=new UserEmployee();
		emp.setUserempid(userEmployeeBean.getUserempid());
		emp.setLoginname(userEmployeeBean.getLoginname());
		emp.setFirstname(userEmployeeBean.getFirstname());
		emp.setLastname(userEmployeeBean.getLastname());
		emp.setDivision(userEmployeeBean.getDivision());
		emp.setRegion(userEmployeeBean.getRegion());
		emp.setDateofjoining(dateformat.parse(userEmployeeBean.getDateofjoining()));
		emp.setAddress(userEmployeeBean.getAddress());
		emp.setDob(dateformat.parse(userEmployeeBean.getDob()));
		emp.setEamil(userEmployeeBean.getEamil());
		emp.setBranch(userEmployeeBean.getBranch());
		emp.setDesignation(userEmployeeBean.getDesignation());
		emp.setGender(userEmployeeBean.getGender());
		emp.setPhone(userEmployeeBean.getPhone());
		emp.setUsermobile(userEmployeeBean.getUsermobile());
		emp.setPassword(userEmployeeBean.getPassword());
		emp.setRepassword(userEmployeeBean.getRepassword());
		emp.setDepartment(userEmployeeBean.getDepartment());
		emp.setMiddlename(userEmployeeBean.getMiddlename());
		emp.setEmpCode(userEmployeeBean.getEmpCode());
		emp.setSubcompany(userEmployeeBean.getSubcompany());
		emp.setActive(true);
		userEmpdao.updateEmp(emp);
		//userEmpdao.updateUser(emp);
		
	}

@Override
public void adddDesignation(DesignationBean designationBean) {
	Designation degn= new Designation();
	degn.setDesignation(designationBean.getDesignation());
	degn.setLevel(designationBean.getLevel());
    //degn.setDesignationid(designationBean.getDesignationid());
   // System.out.println(degn.getDesignationid());
	List<Designation> list=userEmpdao.findlistBylevel();
	
	
	
	for(Designation u:list){
		System.out.println("*************         "+u.getLevel());
	}
	//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%       \n"+list);
	//userEmpdao.createDesign(degn);
	
	/*if(designationBean.getPosition()!=2)
	{
		//int level=degn.getLevel()+1;
		//System.err.println(level);
		//userEmpdao.updateDesign(degn);
	}*/
	
	
}

@Override
public List<String> findDataByDesignation(String designation) {
	List<String> list = userEmpdao.findDesignation(designation);
	/*List<String> listbean = new ArrayList<String>();
	for (S data : list) {
		DesignationBean bean=new DesignationBean();
		bean.setDesignation(data.getDesignation());
		System.out.println(data.getDesignation());
		listbean.add(bean);
		
}*/
 return  list;
	
}

@Override
public List<DesignationBean> getDesignation() {
	 List<Designation> getdetails =userEmpdao.getDesignation();
	List<DesignationBean> lists=new ArrayList<DesignationBean>();
	for(Designation list: getdetails)
	{
		DesignationBean data=new DesignationBean();
		data.setDesignationid(list.getDesignationid());
		data.setDesignation(list.getDesignation());
		lists.add(data);
	}
	return lists;
}

@Override
public List<DesignationBean> getDesignation(int designationid)
{
	List<Designation> list = userEmpdao.getDesignation(designationid);
	List<DesignationBean> listbean = new ArrayList<DesignationBean>();
	for (Designation data : list) {
		DesignationBean userData = new DesignationBean();
		userData.setDesignationid(data.getDesignationid());
		userData.setDesignation(data.getDesignation());
		
		listbean.add(userData);
}
	return listbean;

}	
	

}
