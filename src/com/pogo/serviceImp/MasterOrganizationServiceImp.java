package com.pogo.serviceImp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.text.SimpleDateFormat;
import com.pogo.bean.DesignationBean;
import com.pogo.bean.SmsAllocationBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.bean.ZonesBean;
import com.pogo.dao.MasterOrganizationDao;
import com.pogo.model.CompanyProfile;
import com.pogo.model.Designation;
import com.pogo.model.SmsAllocation;
import com.pogo.model.UserEmployee;
import com.pogo.model.Zones;
import com.pogo.service.MasterOrganizationService;

@Service("regionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MasterOrganizationServiceImp implements MasterOrganizationService{

	@Autowired
	private MasterOrganizationDao regionDao;
	@Autowired
	private MasterOrganizationDao companyProfiledao;
	@Autowired
	private MasterOrganizationDao userEmpdao;

	@Override
	public List<Zones> getBranches() {
		List<Zones> getbranch =regionDao.getBranches();
		for(Zones s:getbranch)
			System.out.println(s.getZonesname());
		
			
	
		return getbranch;
	}

	
	 public ZonesBean  editZones(int empid) {
			Zones zones = regionDao.editZones(empid);
			ZonesBean bean=new ZonesBean();
			bean.setZonesid(zones.getZonesid());
			bean.setZonesname(zones.getZonesname());
			bean.setZonesphone(zones.getZonesphone());
			bean.setZonesemail(zones.getZonesemail());
			bean.setZonesfax(zones.getZonesfax());
			bean.setZonesaddress(zones.getZonesaddress());
			return bean;
}

	 @Override
		public void addZoneDeatils(ZonesBean poref) {
			Zones zon=new Zones();
			
			zon.setZonesaddress(poref.getZonesaddress());
			zon.setZonesemail(poref.getZonesemail());
			zon.setZonesname(poref.getZonesname());
			zon.setZonesfax(poref.getZonesfax());
			zon.setZonesphone(poref.getZonesphone());
			
			
			regionDao.addZoneDeatils(zon);
			
		}


	@Override

	public List<Zones> getStates() {
		List<Zones> getbranch =regionDao.getBranches();
		for(Zones s:getbranch)
			System.out.println(s.getZonesname());
		
			return getbranch;
	
	}


	@Override
	@Transactional
	public void updateregion(ZonesBean zonesBean) {
		Zones zon=new Zones();
		zon.setZonesid(zonesBean.getZonesid());
		zon.setZonesaddress(zonesBean.getZonesaddress());
		zon.setZonesemail(zonesBean.getZonesemail());
		zon.setZonesname(zonesBean.getZonesname());
		zon.setZonesfax(zonesBean.getZonesfax());
		zon.setZonesphone(zonesBean.getZonesphone());
		regionDao.updateRegion(zon);
	}


	@Override
	@Transactional
	public void deleteRegion(int id) {
		Zones zones =regionDao.deleteRegion(id);
		//System.out.println("on service"+zones.getZonesaddress());
		regionDao.deleteRegion(zones);
		
	}
	public void addCompany(CompanyProfile company) {
		companyProfiledao.addCompany(company);
		
	}
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
			data.setFirstname(list.getFirstname());
			data.setMiddlename(list.getMiddlename());
			data.setLastname(list.getLastname());
			data.setDesignation(list.getDesignation());
			lists.add(data);
		}
			return lists;
		
	}

	@Override
	@Transactional
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

@Override
public void updateandinsertbylevel(DesignationBean des) {
	
	Designation d=new Designation();
	
	d.setDesignation(des.getDesignation());
	d.setLevel(des.getLevel());
	List<Designation> list=new ArrayList<>();
	list=userEmpdao.findlistBylevel(des.getLevel());
	
	if(des.getPosition()==2)
	{
		userEmpdao.upDatelevel(d);
	 
	
	}else if(des.getPosition()==1){
		
	}else if(des.getPosition()==0){
		
		
	}
	Designation deg=new Designation();
	deg.setDesignation(des.getDesignation());
	deg.setLevel(des.getLevel());
	userEmpdao.createDesign(deg);
	

	}

@Override
public DesignationBean getDesignationForEdit(int desgid) 
{
	
	List<Designation> designation=userEmpdao.forDesignationGetId(desgid);
	DesignationBean bean=new DesignationBean();
	for(Designation des:designation){
	bean.setDesignationid(des.getDesignationid());
	bean.setDesignation(des.getDesignation());
	}
	return bean;
}

@Override
public void updateDesignation(DesignationBean designationBean) {
	Designation deg=new Designation();
	deg.setDesignationid(designationBean.getDesignationid());
	deg.setDesignation(designationBean.getDesignation());
	userEmpdao.updateDesignation(deg);
}

@Override
public void deleteDesignation(int id) {
	Designation deg = userEmpdao.getDesgById(id);
	userEmpdao.deleteDesignation(deg);
	
}


@Override
@Transactional
public void permitForSms(SmsAllocationBean smsbean) {
	SmsAllocation sms=new SmsAllocation();
	sms.setEmpid(smsbean.getEmpid());
	sms.setIsunlimited("Y");
	userEmpdao.permitForSms(sms);
	
}


@Override
@Transactional
public void denyForSms(SmsAllocationBean smsbean) {
	SmsAllocation sms=new SmsAllocation();
	sms.setEmpid(smsbean.getEmpid());
	 
	userEmpdao.denyForSms(sms);
	
}


@Override
@Transactional
public List<SmsAllocationBean> getPermitSmsUser() {
	
	List<SmsAllocation> getlist=userEmpdao.getPermitSmsUser();
	
	List<SmsAllocationBean> list=new ArrayList<>();
	for(SmsAllocation s:getlist){
		SmsAllocationBean bean=new SmsAllocationBean();
		System.out.println(s.getEmpid());
		bean.setEmpid(s.getEmpid());
		list.add(bean);
	}
	return list;
}




}