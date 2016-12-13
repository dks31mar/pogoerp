package com.pogo.serviceImp;



import java.io.IOException;

import java.text.DateFormat;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.multipart.MultipartFile;


import com.google.gson.Gson;
import com.ibm.icu.text.SimpleDateFormat;
import com.pogo.bean.AddDiaryBean;
import com.pogo.bean.AddFollowUpBean;
import com.pogo.bean.ContactBean;

import com.pogo.bean.CustomerFileUploadBean;
import com.pogo.bean.CustomerLevelsBean;


import com.pogo.bean.CustomerSalesBean;
import com.pogo.dao.CustomerSalesDao;
import com.pogo.dao.MasterMastersDao;
import com.pogo.dao.MasterOrganizationDao;
import com.pogo.model.AddDiary;
import com.pogo.model.AddFollowUp;
import com.pogo.model.Contact;
import com.pogo.model.CustomerLevels;
import com.pogo.model.CustomerSales;
import com.pogo.model.CustomersFileUplaod;
import com.pogo.model.UserEmployee;
import com.pogo.service.CustomerSalesService;

@Service("customerSalesService")
@Transactional
public class CustomerSalesServiceImpl implements CustomerSalesService
{
	@Autowired
	private CustomerSalesDao customerSalesDao;
	@Autowired
	private MasterOrganizationDao empDao;
    @Autowired
    private MasterMastersDao masterMasterDao;
    
	@Override
	public void addCustomerSales(CustomerSalesBean customerSalesBean) throws ParseException
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MMM-dd");
		CustomerSales customerSales=new CustomerSales();
		customerSales.setAddress(customerSalesBean.getAddress());
		customerSales.setContactPerson(customerSalesBean.getContactPerson());
		customerSales.setCreationDate(customerSalesBean.getCreationDate());
		customerSales.setOrderdate(customerSalesBean.getOrderdate());
		customerSales.setMobileNo(customerSalesBean.getMobileNo());
		customerSales.setEmailId(customerSalesBean.getEmailId());
		customerSales.setCategory(customerSalesBean.getCategory());
		customerSales.setOrganisation(customerSalesBean.getOrganisation());
		customerSales.setOrgShortName(customerSalesBean.getOrgShortName());
		customerSales.setTelephoneNo(customerSalesBean.getTelephoneNo());
		customerSales.setAcmanager(customerSalesBean.getAcmanager());
		if(customerSalesBean.getEmpId() > 0){
			customerSales.setInitiatedBy(empDao.get(customerSalesBean.getEmpId()));
			
		}else
			customerSales.setInitiatedBy(null);
		if(customerSalesBean.getDistrictId() > 0)
		{
			customerSales.setDistrictName(masterMasterDao.getDistrictDataById(customerSalesBean.getDistrictId()));
		}else
		customerSales.setDistrictName(null);
		if(customerSalesBean.getCountryId()>0){
			customerSales.setCountry(masterMasterDao.getCountryDataById(customerSalesBean.getCountryId()));
		}else
			customerSales.setCountry(null);
		if(customerSalesBean.getCustomerLevelId()>0)
		{
			customerSales.setStatus(masterMasterDao.getCustomerStatusById(customerSalesBean.getCustomerLevelId()));
			System.out.println("On service customerstatus"+masterMasterDao.getCustomerStatusById(customerSalesBean.getCustomerLevelId()));
		}else
			customerSales.setStatus(null);
		if(customerSalesBean.getStateId()>0)
		{
			customerSales.setState(masterMasterDao.getStatesById(customerSalesBean.getStateId()));
		}else
			customerSales.setState(null);
		
		customerSalesDao.addCutomer(customerSales);
		
	}
	@Override
	public List<CustomerSalesBean> findAllData(String id) {
		List<CustomerSales> sales=customerSalesDao.getsalesList(id);
		List<CustomerSalesBean> salesbean=new ArrayList<CustomerSalesBean>();
		for(CustomerSales data:sales)
		{
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			CustomerSalesBean salebean=new CustomerSalesBean();
			salebean.setCustomerId(data.getCustomerId());
			salebean.setCreationDate(data.getCreationDate());
			salebean.setInitiatedBy(data.getInitiatedBy().getFirstname()+" " +data.getInitiatedBy().getLastname());
			salebean.setAddress(data.getAddress());
			salebean.setOrganisation(data.getOrganisation());
			salebean.setContactPerson(data.getContactPerson());
			salebean.setAddress(data.getAddress());
			salebean.setStatus(data.getStatus().getStatus());
			salesbean.add(salebean);
		}
		return salesbean;
	}
	@Override
public CustomerSalesBean getCustomerDetailsById(int id) {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-dd-MM");
		CustomerSales sales=customerSalesDao.getCustomerDetailsbyId(id);
		CustomerSalesBean bean=new CustomerSalesBean();
		bean.setCustomerId(sales.getCustomerId());
		bean.setAddress(sales.getAddress());
		bean.setAcmanager(sales.getAcmanager());
		bean.setCategory(sales.getCategory());
		bean.setCreationDate(sales.getCreationDate());
		bean.setOrderdate(sales.getOrderdate());
		bean.setEmailId(sales.getEmailId());
		bean.setContactPerson(sales.getContactPerson());
		bean.setMobileNo(sales.getMobileNo());
		bean.setOrganisation(sales.getOrganisation());
		bean.setOrgShortName(sales.getOrgShortName());
		bean.setTelephoneNo(sales.getTelephoneNo());
		if(sales.getLocation()!=null)
		{
			bean.setSublocation(sales.getLocation().getLocation());
			bean.setSublocationId(sales.getLocation().getLocationId());
		}
		if(sales.getInitiatedBy()!=null)
		{
			bean.setEmpId(sales.getInitiatedBy().getUserempid());
			
		}
		if(sales.getCountry()!=null)
		{
			bean.setCountryId(sales.getCountry().getCountryId());
		}
		if(sales.getStatus()!=null)
		{
			bean.setCustomerLevelId(sales.getStatus().getId());
		}
		if(sales.getState()!=null)
		{
			bean.setStateId(sales.getState().getStateId());
		}
		if(sales.getDistrictName()!=null)
		{
			bean.setDistrictId(sales.getDistrictName().getDistrictId());
		}
		return bean;

	}
	@Override

	public void upadtecustomerData(CustomerSalesBean customerSalesBean) throws ParseException 
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-dd-MM");
		CustomerSales sales=new CustomerSales();
		sales.setAddress(customerSalesBean.getAddress());
		sales.setContactPerson(customerSalesBean.getContactPerson());
		sales.setCreationDate(customerSalesBean.getCreationDate());
		sales.setEmailId(customerSalesBean.getEmailId());
		sales.setCategory(customerSalesBean.getCategory());
		sales.setMobileNo(customerSalesBean.getMobileNo());
		sales.setOrderdate(customerSalesBean.getOrderdate());
		sales.setOrganisation(customerSalesBean.getOrganisation());
		sales.setOrgShortName(customerSalesBean.getOrgShortName());
		sales.setTelephoneNo(customerSalesBean.getTelephoneNo());
		if(customerSalesBean.getEmpId()>0)
		{
			sales.setInitiatedBy(empDao.get(customerSalesBean.getEmpId()));
		}else
			sales.setInitiatedBy(null);
		if(customerSalesBean.getCountryId()>0)
		{
			sales.setCountry(masterMasterDao.getCountryDataById(customerSalesBean.getCountryId()));
		}else
			sales.setCountry(null);
		if(customerSalesBean.getCustomerLevelId()>0){
			sales.setStatus(masterMasterDao.getCustomerStatusById(customerSalesBean.getCustomerLevelId()));
		}else
			sales.setStatus(null);
		if(customerSalesBean.getSublocationId()>0)
		{
			sales.setLocation(masterMasterDao.getLocations(customerSalesBean.getSublocationId()));
		}else
			sales.setLocation(null);
		if(customerSalesBean.getStateId()>0)
		{
			sales.setState(masterMasterDao.getStatesById(customerSalesBean.getStateId()));
		}else
			sales.setState(null);
		if(customerSalesBean.getDistrictId()>0){
			sales.setDistrictName(masterMasterDao.getDistrictDataById(customerSalesBean.getDistrictId()));
		}else
			sales.setDistrictName(null);
		customerSalesDao.updateCustomer(sales);
		
		
	}
	@Override
	public void savediary(AddDiaryBean addDiaryBean) {
		AddDiary diary=new AddDiary();
		diary.setDate(addDiaryBean.getDate());
		diary.setAddress(addDiaryBean.getAddress());
		diary.setContacperson(addDiaryBean.getContacperson());
		diary.setDiarytime(addDiaryBean.getTime());
		diary.setDiarytimemin(addDiaryBean.getTimemin());
		diary.setEmail(addDiaryBean.getEmail());
		diary.setMobileno(addDiaryBean.getMobileno());
		diary.setObjective(addDiaryBean.getObjective());
		diary.setOrganizationName(addDiaryBean.getOrganization());
		if(addDiaryBean.getEnteryuserId()>0)
		{
		diary.setEnteryuser(empDao.get(addDiaryBean.getEnteryuserId()));
		}else
			diary.setEnteryuser(null);
		if(addDiaryBean.getDegId()>0){
			diary.setDegName(empDao.getData(addDiaryBean.getDegId()));
		}else
			diary.setDegName(null);
		if(addDiaryBean.getPlanId()>0){
			diary.setPlanName(masterMasterDao.getplanById(addDiaryBean.getPlanId()));
		}else
			diary.setPlanName(null);
		customerSalesDao.saveDiary(diary);
	}
	@Override
	public void addFollowup(AddFollowUpBean addFollowUpBean,int userid) throws IOException {
		AddFollowUp followUp=new AddFollowUp();
		UserEmployee e=new UserEmployee();
		e.setUserempid(userid);
		followUp.setActionTaken(addFollowUpBean.getActionTaken());
		followUp.setFollowupDate(addFollowUpBean.getFollowupDate());
		followUp.setFollowupTimeIn(addFollowUpBean.getFollowupTimeIn());
		followUp.setFollowupTimeOut(addFollowUpBean.getFollowupTimeOut());
		followUp.setContactPerson(addFollowUpBean.getContactPerson());
		followUp.setFollowupTimeInMin(addFollowUpBean.getFollowupTimeInMin());
		followUp.setFollowupTimeOutMin(addFollowUpBean.getFollowupTimeOutMin());
		followUp.setCusStatus(addFollowUpBean.getCustStatus());
		followUp.setCusAddress(addFollowUpBean.getCusAddress());
		followUp.setCusOrganisation(addFollowUpBean.getCusOrganisation());
		followUp.setRemarks(addFollowUpBean.getRemarks());
		followUp.setUserEmp(e);
		if(addFollowUpBean.getActionId()>0)
		{
			followUp.setActionType(masterMasterDao.getActionDataById(addFollowUpBean.getActionId()));
		}else{
			followUp.setActionType(null);

		}
		int id=customerSalesDao.addfollowup(followUp);
		MultipartFile multipartFile = addFollowUpBean.getFile();
		if(multipartFile.isEmpty()!=true){
			CustomersFileUplaod fileUplaod = new CustomersFileUplaod();
			fileUplaod.setFollowupId(id);
			fileUplaod.setFile(multipartFile.getBytes());
			fileUplaod.setFileName(multipartFile.getOriginalFilename());
			fileUplaod.setFileType(multipartFile.getContentType());
			customerSalesDao.savefiles(fileUplaod);
		}
		
		

		if(addFollowUpBean.getUserEmpId()>0)
		{
			followUp.setUserEmp(empDao.get(addFollowUpBean.getUserEmpId()));
		}
		customerSalesDao.addfollowup(followUp);

		
	}
	@Override
	public String findAllDataById() {
		List<CustomerSales> list=customerSalesDao.getsalesListById();
		//List<CustomerLevels> cusStatus=masterMasterDao.getCustomerStatusDetails();
		//List<CustomerSalesBean> listbean=new ArrayList<CustomerSalesBean>();
		
		String json = new Gson().toJson(list);
		
		return json;
	}
	@Override
	public void addContactPerson(ContactBean contactBean) {
		Contact contact=new Contact();
		contact.setContactName(contactBean.getContactName());
		contact.setContemail(contactBean.getContemail());
		contact.setPhone(contactBean.getPhone());
		//contact.setDepName(empDao.getDep(contactBean.getContactId()));
		customerSalesDao.saveContact(contact);
		
	}


	@Override
	public List<AddDiary> getdiarydata() {
		// TODO Auto-generated method stub
		return null;
	}


	
	@Override
	public List<AddDiaryBean> getDiaryRecord() {
		List<AddDiaryBean> bean=new ArrayList<AddDiaryBean>(); 
		List< UserEmployee> getempname=customerSalesDao.getDatafromDiary();
		//Integer getPlan=null;
		for(UserEmployee data:getempname)
		{
			AddDiaryBean beans=new AddDiaryBean();
			//Integer getPlan=customerSalesDao.getPlanByid(data.getUserempid());
			System.out.println(data.getFirstname()+""+data.getLastname());
			
			beans.setEnteryuserId(data.getUserempid());
			beans.setEnteryuser(data.getFirstname()+" "+data.getLastname());
				beans.setTotalsms(customerSalesDao.getTotalsms(data.getUserempid(),1));
			
				System.out.println("2");
				beans.setTotalappointment(customerSalesDao.getTotalappointment(data.getUserempid(),2));
			
				System.out.println("3");
				beans.setTotalemail(customerSalesDao.getTotalemail(data.getUserempid(),3));
			
				System.out.println("4");
				beans.setTotalphone(customerSalesDao.getTotalphone(data.getUserempid(),4));
			
				System.out.println("5");
				beans.setTotalothers(customerSalesDao.getTotalothers(data.getUserempid(),5));
			
				
				beans.setTotal(customerSalesDao.getTotalsms(data.getUserempid(),1)+customerSalesDao.getTotalappointment(data.getUserempid(),2)
				+customerSalesDao.getTotalemail(data.getUserempid(),3)+customerSalesDao.getTotalphone(data.getUserempid(),4)+
				customerSalesDao.getTotalothers(data.getUserempid(),5)
						);
			
			bean.add(beans);
		}
		return bean;
	}
	@Override
	public String getCustomerdatabyCompanyName(String organization) {
		
		List<CustomerSales> getdetail=new ArrayList<CustomerSales>();
		getdetail=customerSalesDao.getCustomerdatabyCompanyName(organization);
		Map<String, String> map=new HashMap<>();
		for(CustomerSales s:getdetail){
			map.put("custid", ""+s.getCustomerId());
			map.put("address", s.getAddress());
			map.put("emailId", s.getEmailId());
			map.put("mobileNo", s.getMobileNo());
			map.put("status", s.getStatus().getStatus());
		}
		String json = new Gson().toJson(map);
		return json;
	}
	@Override

	public void saveFiles(CustomersFileUplaod fileUplaod) 
	{
		customerSalesDao.savefiles(fileUplaod);
		
	}

	public AddDiaryBean editdiaryrecord(int id) 
	{
		AddDiary diary=customerSalesDao.getDiarybyId(id);
		AddDiaryBean diarybean=new AddDiaryBean();
		diarybean.setDiaryId(diary.getDiaryId());
		diarybean.setOrganization(diary.getOrganizationName());
		diarybean.setAddress(diary.getAddress());
		diarybean.setContacperson(diary.getContacperson());
		diarybean.setDate(diary.getDate());
		diarybean.setTime(diary.getDiarytime());
		diarybean.setTimemin(diary.getDiarytimemin());
		diarybean.setObjective(diary.getObjective());
		diarybean.setMobileno(diary.getMobileno());
		diarybean.setEmail(diary.getEmail());
		if(diary.getDegName()!=null)
		{
			diarybean.setDegId(diary.getDegName().getDesignationid());
			//diarybean.setDegName(diary.getDegName().getDesignation());
		}
		if(diary.getPlanName()!=null){
			diarybean.setPlanName(diary.getPlanName().getPlan());
		diarybean.setPlanId(diary.getPlanName().getId());
		}
		if(diary.getEnteryuser()!=null)
		{
			diarybean.setEnteryuserId(diary.getEnteryuser().getUserempid());
		}
		return diarybean;
	}
	@Override
	public void updateDiaryData(AddDiaryBean addDiaryBean) 
	{
		AddDiary addDiary=new AddDiary();
		addDiary.setDiaryId(addDiaryBean.getDiaryId());
		addDiary.setOrganizationName(addDiaryBean.getOrganization());
		addDiary.setAddress(addDiaryBean.getAddress());
		addDiary.setContacperson(addDiaryBean.getContacperson());
		addDiary.setDiarytime(addDiaryBean.getTime());
		addDiary.setDiarytimemin(addDiaryBean.getTimemin());
		addDiary.setObjective(addDiaryBean.getObjective());
		addDiary.setEmail(addDiaryBean.getEmail());
		addDiary.setMobileno(addDiaryBean.getMobileno());
		addDiary.setDate(addDiaryBean.getDate());
		if(addDiaryBean.getPlanId()>0){
			//addDiary.setPlanName(masterMasterDao.getplanById(addDiaryBean.getPlanName()));
			addDiary.setPlanName(masterMasterDao.getplanById(addDiaryBean.getPlanId()));
	     }else
	    	 addDiary.setPlanName(null);
		if(addDiaryBean.getDegId()>0)
		{
			addDiary.setDegName(empDao.getData(addDiaryBean.getDegId()));
		}else
			addDiary.setDegName(null);
		if(addDiaryBean.getEnteryuserId()>0)
		{
			addDiary.setEnteryuser(empDao.get(addDiaryBean.getEnteryuserId()));
		}else
			addDiary.setEnteryuser(null);
		customerSalesDao.updateDiary(addDiary);
	}
	@Override
	public List<AddDiaryBean> getDiaryList(int id, String planId) {
		int pid=Integer.parseInt(planId);
		List<AddDiary> diarylist=null;
		if(id!=0){
		diarylist=customerSalesDao.getdiarydata(id,pid);
		
		}else {
			diarylist=customerSalesDao.getdiarydata1(pid);
		}
		List<AddDiaryBean> diarybean=new ArrayList<AddDiaryBean>();
		for(AddDiary data:diarylist)
		{
			AddDiaryBean bean=new AddDiaryBean();
			bean.setDiaryId(data.getDiaryId());;
			bean.setDate(data.getDate());
			bean.setContacperson(data.getContacperson());
			bean.setTime(data.getDiarytime()+":"+data.getDiarytimemin());
			bean.setObjective(data.getObjective());
			bean.setPlanName(data.getPlanName().getPlan());
			bean.setOrganization(data.getOrganizationName());
			bean.setEnteryuser(data.getEnteryuser().getFirstname()+" "+data.getEnteryuser().getLastname());
			/*bean.setDiaryId(data.getDiaryId());
			//bean.setTime(data.getTime());
			//
			
			
			bean.setAddress(data.getAddress());
			*/
			//diarybean.add(bean);
			//bean.setDiaryId(diarylist.);
			//return bean;
			diarybean.add(bean);
		}
	
		return diarybean;
	}
	@Override

	public List<CustomerFileUploadBean> getFollowupFilesList() {
		List<CustomersFileUplaod> filedata=customerSalesDao.getdatafromfiles();
				List<CustomerFileUploadBean> beans=new ArrayList<CustomerFileUploadBean>();
		for(CustomersFileUplaod data:filedata)
		{
			CustomerFileUploadBean beansddata =new CustomerFileUploadBean();
			beansddata.setCusfileId(data.getCusfileId());
			beansddata.setFollowupId(data.getFollowupId());
			beansddata.setOganisationName(customerSalesDao.getorgName(data.getFollowupId()));
			beansddata.setFileName(data.getFileName());
			beansddata.setFileType(data.getFileType());
			beans.add(beansddata);
		}
		return beans;
	}
	@Override
	public CustomersFileUplaod downloadDataById(int id) 
	{
		return customerSalesDao.getfilesDataBy(id);
		 
	}
	@Override
	public void DeletefileById(int id) {
	CustomersFileUplaod files=customerSalesDao.getfilesDataBy(id);
	customerSalesDao.delateFilesData(files);
		
	}
	@Override
	public String verifyOrg(String organisation) {
		String result="yes";
		CustomerSales sales= customerSalesDao.verifyOrg(organisation);
		if(sales==null)
		{
			result="no";
		}
				
		return result;
	}
	@Transactional
	public JSONArray followUpListByUserId(String sdate,String edate) {
		List<AddFollowUp> list=customerSalesDao.getfollowUpUserId(sdate,edate);
		Object [] s1=(Object[]) list.toArray();
		System.out.println(s1.length);
		
		JSONArray jsonarr=new JSONArray();
	
		for(Object s:s1){
			System.out.println(s);
			
			JSONObject jsonobj=new JSONObject();
			List<AddFollowUpBean> b=new ArrayList<>();
			List<AddFollowUp> list2=customerSalesDao.followUpListByUserId(s,sdate,edate);
			for(AddFollowUp afoll:list2){
				System.out.println(afoll.getFollowupDate());
				jsonobj.put("name", afoll.getUserEmp().getFirstname()+" "+afoll.getUserEmp().getLastname());
				jsonobj.put("followupid", afoll.getFollowUpId());
				jsonobj.put("Userempid", afoll.getUserEmp().getUserempid());
				AddFollowUpBean bean=new AddFollowUpBean();
				bean.setFollowUpId(afoll.getFollowUpId());
				bean.setFollowupDate(afoll.getFollowupDate());
				b.add(bean);
			}
			List<String> dates=new ArrayList<>();
			List<Object> datenids=new ArrayList<>();
			Iterator<AddFollowUpBean> itr=b.iterator();
			while (itr.hasNext()) {
				AddFollowUpBean addFollowUpBean = (AddFollowUpBean) itr.next();
				dates.add(addFollowUpBean.getFollowupDate());
				datenids.add(addFollowUpBean.getFollowupDate());
				datenids.add(Integer.toString(addFollowUpBean.getFollowUpId()));
				System.out.println(">>>>>>>>>>>>      "+addFollowUpBean.getFollowupDate());
			}		
			TreeSet<String> unique = new TreeSet<String>(dates);
			String json="";
			String splitdate="";
			for(String bean1:unique){
				splitdate=bean1.split("/")[0].replaceFirst("^0+(?!$)", "");
				json+=splitdate + ": " + Collections.frequency(dates, bean1)+",";
				
			}
			
			json = json.replaceAll(",$", "");
			jsonobj.put("NoOfcount",json);
			jsonarr.put(jsonobj);
		
		}
		
		
			
	System.out.println(jsonarr);
		
		return jsonarr;
	}
	@Override
	@Transactional
	public List<AddFollowUpBean> getfollowuplistbydatenid(String sdate, String edate, String empid,String day) {
		List<AddFollowUp> list2=customerSalesDao.followUpListByUserId1(empid,sdate,edate,day);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>          Size      "+list2.size());
		List<AddFollowUpBean> b=new ArrayList<>();
		
		for(AddFollowUp afoll:list2){
			System.out.println(afoll.getFollowupDate());
			
			AddFollowUpBean bean=new AddFollowUpBean();
			bean.setFollowUpId(afoll.getFollowUpId());
			bean.setFollowupDate(afoll.getFollowupDate());
			bean.setCusOrganisation(afoll.getCusOrganisation());
			bean.setFollowupTimeIn(afoll.getFollowupTimeIn()+":"+afoll.getFollowupTimeInMin());
			bean.setFollowupTimeOut(afoll.getFollowupTimeOut()+":"+afoll.getFollowupTimeOutMin());
			bean.setContactPerson(afoll.getContactPerson());
			bean.setCustStatus(afoll.getCusStatus());
			bean.setRemarks(afoll.getRemarks());
			
			b.add(bean);
		}
		return b;
	}
	@Override
	public String getfollowuplistbydatenid1(String sdate, String edate, String empid, String day) {
		List<AddFollowUp> list2=customerSalesDao.followUpListByUserId1(empid,sdate,edate,day);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>          Size      "+list2.size());
		String content="";
		List<AddFollowUpBean> b=new ArrayList<>();
		int i=1;
		
		if(!list2.isEmpty()){
			content="<table id='unstyled' border=1><thead>"+
					  "<tr>"+
						    "<th>S.N.</th>"+
						    "<th><span>Follow up Date</span></th>"+
						    "<th>In Time</th>"+
						    "<th>Out Time</th>"+
						    "<th>Hours of metting(HOM)</th>"+
					     	"<th> Customer</th>"+
					      	"<th>Contact Person</th>"+
					      	"<th> Status</th>"+
					        "<th> Follow up Type</th>"+
					        "<th> Remark</th>"+
					        "<th> Next Followup Date</th>"+
					          
					  "</tr>"+
					  "</thead>";
							content+="<tbody>";
							for(AddFollowUp afoll:list2){
								content+="<tr>";
								content+="<td>"+i+++"</td>";
								content+="<td>"+afoll.getFollowupDate()+"</td>";
								content+="<td>"+afoll.getFollowupTimeIn()+":"+afoll.getFollowupTimeInMin()+"</td>";
								content+="<td>"+afoll.getFollowupTimeOut()+":"+afoll.getFollowupTimeOutMin()+"</td>";
								content+="<td></td>";
								content+="<td>"+afoll.getCusOrganisation()+"</td>";
								content+="<td>"+afoll.getContactPerson()+"</td>";
								
								content+="<td>"+afoll.getCusStatus()+"</td>";
								content+="<td></td>";
								content+="<td>"+afoll.getRemarks()+"</td>";
								content+="<td></td>";
								System.out.println(afoll.getFollowupDate());
								
								AddFollowUpBean bean=new AddFollowUpBean();
								bean.setFollowUpId(afoll.getFollowUpId());
								bean.setFollowupDate(afoll.getFollowupDate());
								bean.setCusOrganisation(afoll.getCusOrganisation());
								bean.setFollowupTimeIn(afoll.getFollowupTimeIn()+":"+afoll.getFollowupTimeInMin());
								bean.setFollowupTimeOut(afoll.getFollowupTimeOut()+":"+afoll.getFollowupTimeOutMin());
								bean.setContactPerson(afoll.getContactPerson());
								bean.setCustStatus(afoll.getCusStatus());
								bean.setRemarks(afoll.getRemarks());
								content+="</tr>";
								b.add(bean);
							}
							content+="</tbody>";
							content+="</table>";
		}else{
			content+="<h2>No Follow Up Found</h2>";
		}
		
		
		return content;
	}
	@Override
	public Map<String, String> findocountofstatus() {
		List<CustomerLevels> list=customerSalesDao.getlistcustomerlevel();
		Map<String, String> map=new HashMap<>();
		for(CustomerLevels sl:list){
			int totalcount=customerSalesDao.getcountcustomerlevel(sl);
			map.put(sl.getStatus(), Integer.toString(totalcount));
		}
		System.out.println(map);
		return map;

	}
	
	

}
	
	

	



