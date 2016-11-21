package com.pogo.serviceImp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.buf.UDecoder;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.text.SimpleDateFormat;

import com.pogo.bean.BranchBean;
import com.pogo.bean.CompanyProfileBean;

import com.pogo.bean.CompetitiorsProfileBean;

import com.pogo.bean.DesignationBean;
import com.pogo.bean.SmsAllocationBean;
import com.pogo.bean.StatezoneBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.bean.ZonesBean;

import com.pogo.dao.MasterOrganizationDao;
import com.pogo.model.Branch;
import com.pogo.model.CompanyProfile;
import com.pogo.model.CompetitiorsProfile;
import com.pogo.model.Designation;
import com.pogo.model.SmsAllocation;
import com.pogo.model.StateZone;
import com.pogo.model.UserEmployee;
import com.pogo.model.Zones;
import com.pogo.service.MasterOrganizationService;
import com.sun.corba.se.impl.ior.GenericTaggedComponent;

@Service("regionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MasterOrganizationServiceImp implements MasterOrganizationService{

	@Autowired
	private MasterOrganizationDao regionDao;
	@Autowired
	private MasterOrganizationDao companyProfiledao;
	@Autowired
	private MasterOrganizationDao userEmpdao;
	


	
	
	/********************* created by satyendra  *************************************/
	
	@Override
	public void addBranch(BranchBean branchBean) {
		Branch branch=new Branch();
		branch.setBranchname(branchBean.getBranchname());
		branch.setStateNames(regionDao.getStates(branchBean.getBranchId()));
		
		regionDao.addBranch(branch);
		
		
	}
	@Override
	public List<StatezoneBean> getstateData() {
		List<StateZone> list=regionDao.getstateData();
		List<StatezoneBean> bean=new ArrayList<StatezoneBean>();
		for(StateZone data:list)
		{
			StatezoneBean statezoneBean=new StatezoneBean();
			statezoneBean.setStateId(data.getStateId());
			statezoneBean.setStateName(data.getStateName());
			bean.add(statezoneBean);
					
		    
		}
		return bean;
	}
	@Override
	public List<BranchBean> getStateBranch() {
		List<Branch> lists=regionDao.getbranchDetails();
		List<BranchBean> listbean=new ArrayList<BranchBean>();
		for(Branch branch:lists)
		{
			BranchBean branchbean=new BranchBean();
			branchbean.setBranchId(branch.getBranchId());
			branchbean.setBranchname(branch.getBranchname());
			//branchbean.setStateId(branch.getStateNames().getStateId());
			//branchbean.setState(branch.getStateNames().getStateName());
			listbean.add(branchbean);
		}
		return listbean;
	}
	
	@Override
	public void addStates(StatezoneBean statezoneBean) {
		StateZone stateZone=new StateZone();
		stateZone.setStateName(statezoneBean.getStateName());
		stateZone.setZones(regionDao.getZone(statezoneBean.getStateId()));
		regionDao.addStateDeatils(stateZone);
		
	}
	@Override
	public List<ZonesBean> getZoneslist() {
		List<Zones> zones= regionDao.getZones();
		List<ZonesBean> list=new ArrayList<ZonesBean>();
		for(Zones data:zones)
		{
			ZonesBean beans=new ZonesBean();
			beans.setZonesid(data.getZonesid());
			beans.setZonesname(data.getZonesname());
			list.add(beans);
		}
		return list;
	}
	@Override
	public BranchBean getbranchById(int id) {
		Branch branch=regionDao.getDataById(id);
		BranchBean branchbean=new BranchBean();
		branchbean.setBranchId(branch.getBranchId());
		branchbean.setBranchname(branch.getBranchname());
		return branchbean;
	}
	@Override
	public StatezoneBean getSatesById(int id) 
	{
		StateZone stateZone=regionDao.getStatesId(id);
		System.out.println(stateZone);
		StatezoneBean  bean=new StatezoneBean();
		bean.setStateId(stateZone.getStateId());
		bean.setStateName(stateZone.getStateName());
		return bean;
		
	}
	
	
	
	
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
		System.out.println("are u sure delete the record");
		regionDao.deleteRegion(zones);
		
	}

	@Override
	@Transactional
	public void saveDataCompetitiors(CompetitiorsProfileBean poref) {
		CompetitiorsProfile compti=new CompetitiorsProfile();
		
		compti.setCompname(poref.getCompname());
		compti.setCompaddress(poref.getCompaddress());
		compti.setCompphone(poref.getCompphone());
		compti.setCompfax(poref.getCompfax());
		compti.setCompemail1(poref.getCompemail1());
		compti.setCompcontactperson(poref.getCompcontactperson());
		compti.setCompcontactdesig(poref.getCompcontactdesig());
		compti.setCompemail2(poref.getCompemail2());
		compti.setCompphone2(poref.getCompphone2());
		regionDao.saveDataCompetitiors(compti);
		
	}
		
	
	



	/*************************************end satyendra's method *****************************/
	public void addCompany(CompanyProfile company) {
		companyProfiledao.addCompany(company);
		
	}
	@Override
	public void adduserEmp(UserEmployeeBean userDTO) throws ParseException 
	{
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
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
	    emp.setBranchName(userEmpdao.getBranch(userDTO.getBranchId()));
		emp.setCompanyName(userEmpdao.getCom(userDTO.getSubcompanyId()));
		emp.setDesignationName(userEmpdao.getData(userDTO.getDesignationId()));
		emp.setGender(userDTO.getGender());
		emp.setPhone(userDTO.getPhone());
		emp.setUsermobile(userDTO.getUsermobile());
		emp.setPassword(userDTO.getPassword());
		emp.setRepassword(userDTO.getRepassword());
		emp.setDepartment(userDTO.getDepartment());
		emp.setEmpCode(userDTO.getEmpCode());
		emp.setMiddlename(userDTO.getMiddlename());
		
		
		
		emp.setActive(true);
		emp.setEmpStatus(true);
		userEmpdao.addUser(emp);
		
	}


	@Override
	public List<UserEmployeeBean> getUserDetails() 
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		List<UserEmployee> getdetails =userEmpdao.getuserData();
		List<UserEmployeeBean> lists=new ArrayList<UserEmployeeBean>();
		for(UserEmployee list: getdetails)
		{
			UserEmployeeBean data=new UserEmployeeBean();
			data.setUserempid(list.getUserempid());
			data.setLoginname(list.getLoginname());

			data.setFirstname(list.getFirstname() +""+list.getMiddlename()+""+ list.getLastname() );
			data.setDeviceno(list.getDeviceno());
			data.setDesignationName(list.getDesignationName().getDesignation());
			data.setEmpStatus(list.getEmpStatus());
			data.setBranchName(list.getBranchName().getBranchname());
			/*String date1=(dateformat.format(list.getDateofjoining()));
			String date2=date1.split("00:00:00:0")[0];
			data.setDateofjoining(date2);*/
			data.setDateofjoining(dateformat.format(list.getDateofjoining()));

			data.setFirstname(list.getFirstname());
			data.setMiddlename(list.getMiddlename());
			data.setLastname(list.getLastname());
			//data.setDesignation(list.getDesignation());

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
			userData.setFirstname(data.getFirstname()+""+ data.getMiddlename()+""+data.getLastname());
			userData.setDesignationName(data.getDesignationName().getDesignation());
			userData.setDeviceno(data.getDeviceno());
			userData.setEmpStatus(data.getEmpStatus());
			
			
			listbean.add(userData);
		
	}

		return listbean;
	}

	@Override
	public UserEmployeeBean getEmployee(int empid) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		UserEmployee empedit = userEmpdao.getEmployee(empid);
		UserEmployeeBean empbean = new UserEmployeeBean();
		empbean.setUserempid(empedit.getUserempid());
		empbean.setLoginname(empedit.getLoginname());
		empbean.setDesignationId(empedit.getDesignationName().getDesignationid());
		empbean.setBranchId(empedit.getBranchName().getBranchId());
	    empbean.setSubcompanyId(empedit.getCompanyName().getCompanyinfoid());
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
		
		empbean.setPassword(empedit.getPassword());
		empbean.setRepassword(empedit.getRepassword());
		empbean.setMiddlename(empedit.getMiddlename());
		empbean.setDepartment(empedit.getDepartment());
		empbean.setEmpCode(empedit.getEmpCode());
		
		return empbean;
		
	}
@Transactional
	@Override
	public void updateEmployee(UserEmployeeBean userEmployeeBean) throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
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
		emp.setDesignationName(userEmpdao.getData(userEmployeeBean.getDesignationId()));
		emp.setBranchName(userEmpdao.getBranch(userEmployeeBean.getBranchId()));
		emp.setCompanyName(userEmpdao.getCom(userEmployeeBean.getSubcompanyId()));
		emp.setGender(userEmployeeBean.getGender());
		emp.setPhone(userEmployeeBean.getPhone());
		emp.setUsermobile(userEmployeeBean.getUsermobile());
		emp.setPassword(userEmployeeBean.getPassword());
		emp.setRepassword(userEmployeeBean.getRepassword());
		emp.setDepartment(userEmployeeBean.getDepartment());
		emp.setMiddlename(userEmployeeBean.getMiddlename());
		emp.setEmpCode(userEmployeeBean.getEmpCode());
		emp.setActive(true);
		emp.setEmpStatus(true);
		userEmpdao.updateEmp(emp);
		//userEmpdao.updateUser(emp);
		
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
@Transactional
public void updateDesignation(DesignationBean designationBean) {
	Designation deg=new Designation();
	deg.setDesignationid(designationBean.getDesignationid());
	deg.setDesignation(designationBean.getDesignation());
	userEmpdao.updateDesignation(deg);
}

@Override
@Transactional
public void deleteDesignation(int id) {
	Designation deg = userEmpdao.getDesgById(id);
	userEmpdao.deleteDesignation(deg);
	
}


@Override

@Transactional
public void updateStatus(int id) 
{
	UserEmployee emp=userEmpdao.get(id);
	System.out.println("On servive"+emp.getUserempid());
	if(emp.getEmpStatus()==true)
	{
		emp.setEmpStatus(false);
	}else{
		emp.setEmpStatus(true);
		userEmpdao.updateEmpStatus(emp);
	}
	
	
}


@Override
public List<DesignationBean> GetDesignationList() {
	List<Designation> role=userEmpdao.getDesgnationData();
	System.out.println("" +userEmpdao.getDesignation());
	List<DesignationBean> designationBeans = new ArrayList<DesignationBean>();
	for(Designation data:role)
	{
		DesignationBean desigBean=new DesignationBean();
		desigBean.setDesignationid(data.getDesignationid());
		desigBean.setDesignation(data.getDesignation());
		designationBeans.add(desigBean);
	}
	return designationBeans;
}


@Override
public List<CompanyProfileBean> getCompanyList() {
	List<CompanyProfile> comp= userEmpdao.getCompanyData();
	List<CompanyProfileBean> combeans= new ArrayList<CompanyProfileBean>();
	for(CompanyProfile compn: comp)
	{
		CompanyProfileBean  comModel=new CompanyProfileBean();
		comModel.setCompanyinfoid(compn.getCompanyinfoid());
		comModel.setCompanyinfoname(compn.getCompanyinfoname());
		combeans.add(comModel);
	}
	return combeans;
}


@Override
public List<BranchBean> getBranchList() 
{
	List<Branch> branch= userEmpdao.getBranchData();
	List<BranchBean> branchbean= new ArrayList<BranchBean>();
	for(Branch data:branch)
	{
		BranchBean branchBeans=new BranchBean();
		branchBeans.setBranchId(data.getBranchId());
		branchBeans.setBranchname(data.getBranchname());
		branchbean.add(branchBeans);
		
	}
	
	return branchbean;
}

public void updateCompetitior() {
	CompetitiorsProfile comprof=new CompetitiorsProfile();
	comprof.setCompname(CompetitiorsProfileBean.getCompname());
	comprof.setCompaddress(CompetitiorsProfileBean.getCompaddress());
	comprof.setCompphone(CompetitiorsProfileBean.getCompphone());
	comprof.setCompfax(CompetitiorsProfileBean.getCompfax());
	comprof.setCompemail1(CompetitiorsProfileBean.getCompemail1());
	comprof.setCompcontactperson(CompetitiorsProfileBean.getCompcontactperson());
	comprof.setCompcontactdesig(CompetitiorsProfileBean.getCompcontactdesig());
	comprof.setCompemail2(CompetitiorsProfileBean.getCompemail2());
	comprof.setCompphone2(CompetitiorsProfileBean.getCompphone2());
	regionDao.updateCompetitior(comprof);
}

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


@Override
public List<StatezoneBean> getZoneStates(Integer id) {
	List<StateZone> sz=regionDao.getZoneStates(id);
	List<StatezoneBean> bean=new ArrayList<>();
	for(StateZone s:sz){
		StatezoneBean sBean=new StatezoneBean();
		sBean.setStateId(s.getStateId());
		sBean.setStateName(s.getStateName());
		System.out.println(s.getStateName());
		bean.add(sBean);
	}
	return bean;
}

@Override
@Transactional
public void updateBranch(BranchBean branchBean) {
	Branch branch =new Branch();
	branch.setBranchId(branchBean.getBranchId());
	branch.setBranchname(branchBean.getBranchname());
	System.out.println(branchBean.getBranchname());
	regionDao.updateBranch(branch);
	
}

@Override
@Transactional
public void deletestate(int id) {
	
	StateZone stateZone= regionDao.deleteState(id);
	regionDao.deletedata(stateZone);
	
}

@Override
@Transactional
public void deletebranch(int id) {
	Branch branch=regionDao.deleteBranch(id);
	regionDao.deletebr(branch);
	
}
@Override
@Transactional
public void updateState(StatezoneBean statezoneBean) {
	StateZone stateZone=new StateZone();
	stateZone.setStateId(statezoneBean.getStateId());
	System.out.println("on service"+ statezoneBean.getStateId()+statezoneBean.getStateName());
	stateZone.setStateName(statezoneBean.getStateName());
	regionDao.updateStates(stateZone);
	
}

@Override
public List<BranchBean> getBranchByState(int id) 
{
	List<Branch>list= regionDao.getBranchbystate(id);
	List<BranchBean> beans=new ArrayList<>();
	for(Branch branch:list)
	{
		BranchBean branch1=new BranchBean();
		branch1.setBranchId(branch.getBranchId());
		branch1.setBranchname(branch.getBranchname());
		
		beans.add(branch1);
	}
	return beans;
}

}