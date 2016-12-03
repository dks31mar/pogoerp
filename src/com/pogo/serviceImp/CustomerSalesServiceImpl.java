package com.pogo.serviceImp;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.CipherInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.text.SimpleDateFormat;
import com.pogo.bean.AddDiaryBean;
import com.pogo.bean.AddFollowUpBean;
import com.pogo.bean.ContactBean;
import com.pogo.bean.CustomerSalesBean;
import com.pogo.dao.CustomerSalesDao;
import com.pogo.dao.MasterMastersDao;
import com.pogo.dao.MasterOrganizationDao;
import com.pogo.model.AddDiary;
import com.pogo.model.AddFollowUp;
import com.pogo.model.Contact;
import com.pogo.model.CustomerLevels;
import com.pogo.model.CustomerSales;
import com.pogo.model.Department;
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
	public List<CustomerSalesBean> findAllData() {
		List<CustomerSales> sales=customerSalesDao.getsalesList();
		List<CustomerSalesBean> salesbean=new ArrayList<CustomerSalesBean>();
		for(CustomerSales data:sales)
		{
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			CustomerSalesBean salebean=new CustomerSalesBean();
			salebean.setCustomerId(data.getCustomerId());
			salebean.setCreationDate(data.getCreationDate());
			//salebean.setAcmanager(data.getInitiatedBy().getFirstname());
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
		diary.setEmail(addDiaryBean.getEmail());
		diary.setMobileno(addDiaryBean.getMobileno());
		diary.setObjective(addDiaryBean.getObjective());
		diary.setOrganizationName(addDiaryBean.getOrganization());
		diary.setTasktype(addDiaryBean.getTasktype());
		diary.setEnteryuser(empDao.get(addDiaryBean.getEnteryuserId()));
		customerSalesDao.saveDiary(diary);
	}
	@Override
	public void addFollowup(AddFollowUpBean addFollowUpBean) {
		AddFollowUp followUp=new AddFollowUp();
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
		if(addFollowUpBean.getActionId()>0)
		{
			followUp.setActionType(masterMasterDao.getActionDataById(addFollowUpBean.getActionId()));
		}else
			followUp.setActionType(null);
		customerSalesDao.addfollowup(followUp);
		
	}
	@Override
	public List<CustomerSalesBean> findAllDataById(int id) {
		List<CustomerSales> list=customerSalesDao.getsalesListById(id);
		List<CustomerLevels> cusStatus=masterMasterDao.getCustomerStatusDetails();
		List<CustomerSalesBean> listbean=new ArrayList<CustomerSalesBean>();
		String [] status=cusStatus.toArray(new String[cusStatus.size()]);
		for(CustomerSales data:list)
		{
			CustomerSalesBean salesBean=new CustomerSalesBean();
			salesBean.setCustomerId(data.getCustomerId());
			salesBean.setAddress(data.getAddress());
			salesBean.setStatus(data.getStatus().getStatus());
			salesBean.setStatusList(status);
			//System.out.println("On Service customer"+ data.getAddress()+data.getStatus().getStatus());
			listbean.add(salesBean);
		}
		return listbean;
	}
	@Override
	public void addContactPerson(ContactBean contactBean) {
		Contact contact=new Contact();
		contact.setContactName(contactBean.getContactName());
		contact.setContemail(contactBean.getContemail());
		contact.setPhone(contactBean.getPhone());
		contact.setDepName(empDao.getDep(contactBean.getContactId()));
		customerSalesDao.saveContact(contact);
		
	}
	
	

	


}
