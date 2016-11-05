package com.pogo.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.pogo.bean.CurrencyBean;
import com.pogo.bean.ProductHeadBean;
import com.pogo.bean.ProductSubHeadBean;
import com.pogo.bean.UnitBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.dao.MasterProductDao;
import com.pogo.model.Currency;
import com.pogo.model.ProductHead;
import com.pogo.model.ProductSubHead;
import com.pogo.model.Unit;
import com.pogo.model.UserEmployee;
import com.pogo.service.MasterProductService;
@Service("masterProductService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MasterProductServiceImp implements MasterProductService{

	
	@Autowired
	private MasterProductDao masterProductDao;

	@Override
	public List<CurrencyBean> getCurrencyDetails() {
		List<Currency> getdetails =masterProductDao.getCurrencyData();
		List<CurrencyBean> lists=new ArrayList<CurrencyBean>();
		for(Currency list: getdetails)
		{
			CurrencyBean data=new CurrencyBean();
			data.setCurrencyid(list.getCurrencyid());
			data.setCurrencyname(list.getCurrencyname());
			data.setCurrencysymbol(list.getCurrencysymbol());
			//data.setFirstname(list.getFirstname() + list.getLastname() );
			data.setCurrencytype(list.getCurrencytype());
			lists.add(data);
		}
			
		
		return lists;
	}

	@Override
	public void addCurrency(CurrencyBean poref1) {
		Currency cur=new Currency();
		cur.setCurrencyname(poref1.getCurrencyname());
		cur.setCurrencysymbol(poref1.getCurrencysymbol());
		cur.setCurrencytype(poref1.getCurrencytype());
		masterProductDao.addCurrency(cur);
	}

	@Override
	public void deleteCurrency(int id) {
		masterProductDao.deleteCurrency(id);
	}

	@Override
	public String getCurrency(String id) {
		List<Currency> emp=masterProductDao.getCurrency(id);
		Map<String, Object> dd=new HashMap<>();
 		for(Currency data: emp)
		{
			CurrencyBean cur = new CurrencyBean();
			cur.setCurrencyid(data.getCurrencyid());
			cur.setCurrencyname(data.getCurrencyname());
			cur.setCurrencysymbol(data.getCurrencysymbol());
			cur.setCurrencytype(data.getCurrencytype());
			
			dd.put("id", data.getCurrencyid());
			dd.put("name", data.getCurrencyname());
			dd.put("sysmbol",data.getCurrencysymbol());
			dd.put("type",data.getCurrencytype());
		}
 		Gson gson=new Gson();
 		
 	String currencyString=	gson.toJson(dd);
		
		return currencyString;
	}

	@Override
	@Transactional
	public void editCurrency(CurrencyBean poref1) {
		System.out.println("service method");
		Currency cur=new Currency();
		cur.setCurrencyid(poref1.getCurrencyid());
		cur.setCurrencyname(poref1.getCurrencyname());
		cur.setCurrencysymbol(poref1.getCurrencysymbol());
		cur.setCurrencytype(poref1.getCurrencytype());
		masterProductDao.editCurrency(cur);
		
	}

	@Override
	public List<UnitBean> getUnitsDetails() {
		List<Unit> getdetails =masterProductDao.getUnitsData();
		List<UnitBean> lists=new ArrayList<UnitBean>();
		for(Unit list: getdetails)
		{
			UnitBean data=new UnitBean();
			data.setUnittype(list.getUnittype());
			data.setUnittypeid(list.getUnittypeid());
			
			lists.add(data);
		}
			
		
		return lists;
	}

	@Override
	@Transactional
	public void addUnit(UnitBean poref1) {
		Unit cur=new Unit();
		cur.setUnittype(poref1.getUnittype());
		
		masterProductDao.addUnit(cur);
		
	}

	@Override
	public void deleteUnit(int id) {
		masterProductDao.deleteUnit(id);
	}

	@Override
	public String getUnitById(String id) {
		List<Unit> emp=masterProductDao.getUnitById(id);
		Map<String, Object> dd=new HashMap<>();
 		for(Unit data: emp)
		{
			
			dd.put("id", data.getUnittypeid());
			dd.put("Unittype", data.getUnittype());
			
		}
 		Gson gson=new Gson();
 		
 	String currencyString=	gson.toJson(dd);
		
		return currencyString;

	}

	@Override
	@Transactional
	public void editUnit(UnitBean poref1) {
		
		Unit cur=new Unit();
		cur.setUnittypeid(poref1.getUnittypeid());
		cur.setUnittype(poref1.getUnittype());
		
		masterProductDao.editUnit(cur);
	}

	@Override
	public List<ProductHeadBean> getProductHeadDetails() {
		List<ProductHead> getdetails =masterProductDao.getProductHeadData();
		List<ProductHeadBean> lists=new ArrayList<ProductHeadBean>();
		for(ProductHead list: getdetails)
		{
			ProductHeadBean data=new ProductHeadBean();
			data.setProductheadid(list.getProductheadid());
			data.setProductheadname(list.getProductheadname());
			
			lists.add(data);
		}
			
		
		return lists;
	}

	@Override
	public void addProductHead(ProductHeadBean poref1) {
		ProductHead cur=new ProductHead();
		cur.setProductheadname(poref1.getProductheadname());
		
		masterProductDao.addProductHead(cur);
		
	}

	@Override
	public void deleteProductHead(int id) {
		masterProductDao.deleteProductHead(id);
		
	}

	@Override
	@Transactional
	public void editProductHead(ProductHeadBean poref1) {
		ProductHead cur=new ProductHead();
		cur.setProductheadname(poref1.getProductheadname());
		cur.setProductheadid(poref1.getProductheadid());
		
		masterProductDao.editProductHead(cur);
	}

	@Override
	public String getProductHeadById(String id) {
		List<ProductHead> emp=masterProductDao.getProductHeadById(id);
		Map<String, Object> dd=new HashMap<>();
 		for(ProductHead data: emp)
		{
			
			dd.put("id", data.getProductheadid());
			dd.put("productname", data.getProductheadname());
			
		}
 		Gson gson=new Gson();
 		
 	String currencyString=	gson.toJson(dd);
		
		return currencyString;

	}

	@Override
	public void addProductSubHead(ProductSubHeadBean poref1) {
		
		ProductSubHead cur=new ProductSubHead();
		cur.setProductheadid(poref1.getProductheadid());
		cur.setProductsubheadname(poref1.getProductsubheadname());
		
		masterProductDao.addProductSubHead(cur);
		
	}

	
}
