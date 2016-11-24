package com.pogo.serviceImp;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.text.SimpleDateFormat;
import com.pogo.bean.CustomerSalesBean;
import com.pogo.dao.CustomerSalesDao;
import com.pogo.dao.MasterMastersDao;
import com.pogo.dao.MasterOrganizationDao;
import com.pogo.model.CustomerSales;
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
		//customerSales.setCreationDate(customerSalesBean.getCreationDate());
		customerSales.setOrderdate(customerSalesBean.getOrderdate());
		//customerSales.setCreationDate(dateFormat.format((customerSalesBean.getCreationDate()));
		//customerSales.setOrderdate(dateFormat.parse(customerSalesBean.getOrderdate()));
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
		/*if(customerSalesBean.getDistrictId() > 0)
		{
			customerSales.setDistrictName(masterMasterDao.getDistrictDataById(customerSalesBean.getDistrictId()));
		}else
		customerSales.setDistrictName(null);*/
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
		/*if(customerSalesBean.getStateId()>0)
		{
			customerSales.setState(masterMasterDao.getStatesById(customerSalesBean.getStateId()));
		}else
			customerSales.setState(null);
		
		customerSalesDao.addCutomer(customerSales);*/
		if(customerSalesBean.getSublocationId()>0)
		{
			customerSales.setLocation(masterMasterDao.getLocations(customerSalesBean.getSublocationId()));
		}else
			customerSales.setLocation(null);
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
			salebean.setCreationDate(df.format(data.getCreationDate()));
			//salebean.setAcmanager(data.getInitiatedBy().getFirstname());
			salebean.setAddress(data.getAddress());
			salebean.setOrganisation(data.getOrganisation());
			salebean.setContactPerson(data.getContactPerson());
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
		bean.setCreationDate(df.format(sales.getCreationDate()));
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
		return bean;

	}
	@Override
	public void SaveDiaryForEntery() {
		// TODO Auto-generated method stub
		
	}
	

}
