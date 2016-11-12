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
import com.pogo.bean.ProductMasterBean;
import com.pogo.bean.ProductSubHeadBean;
import com.pogo.bean.UnitBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.dao.MasterProductDao;
import com.pogo.model.Currency;
import com.pogo.model.ProductHead;
import com.pogo.model.ProductMaster;
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
			
			dd.put("currencyid", data.getCurrencyid());
			dd.put("currencyname", data.getCurrencyname());
			dd.put("currencysymbol",data.getCurrencysymbol());
			dd.put("currencytype",data.getCurrencytype());
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
			
			dd.put("unittypeid", data.getUnittypeid());
			dd.put("unittype", data.getUnittype());
			
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
			dd.put("productheadid", data.getProductheadid());
			dd.put("productheadname", data.getProductheadname());
			
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

	@Override
	public List<ProductMasterBean> getProDetails() {
		List<ProductMaster> getdetails =masterProductDao.getProData();
		List<ProductMasterBean> lists=new ArrayList<ProductMasterBean>();
		for(ProductMaster list: getdetails)
		{
			ProductMasterBean data=new ProductMasterBean();
			data.setProductid(list.getProductid());
			data.setProductcode(list.getProductcode());
			data.setProductname(list.getProductname());
			data.setCostprice(list.getCostprice());
			data.setSellingprice(list.getSellingprice());
			
			lists.add(data);
		}
			
		
		return lists;
	}

	@Override
	public void deleteProductData(int id) {
		masterProductDao.deleteProductData(id);
		
	}

	@Override
	public List<ProductMasterBean> searchProductbynameandcode(String proname) {
		List<ProductMaster> getdetails =masterProductDao.searchProData(proname);
		List<ProductMasterBean> lists=new ArrayList<ProductMasterBean>();
		for(ProductMaster list: getdetails)
		{
			ProductMasterBean data=new ProductMasterBean();
			data.setProductid(list.getProductid());
			data.setProductcode(list.getProductcode());
			data.setProductname(list.getProductname());
			data.setCostprice(list.getCostprice());
			data.setSellingprice(list.getSellingprice());
			System.out.println(list.getProductname());
			lists.add(data);
		}
			
		return lists;
	}

	@Override
	public List<ProductSubHeadBean> getProductSubHead() {
		List<ProductSubHead> getdetails =masterProductDao.getProductSubHeadData();
		List<ProductSubHeadBean> lists=new ArrayList<ProductSubHeadBean>();
		for(ProductSubHead list: getdetails)
		{
			ProductSubHeadBean data=new ProductSubHeadBean();
			data.setProductsubheadid(list.getProductsubheadid());
			data.setProductsubheadname(list.getProductsubheadname());
			
			lists.add(data);
		}
			
		
		return lists;
	}

	@Override
	public void addProduct(ProductMasterBean poref) {
		ProductMaster promaster=new ProductMaster();
		
		
		  promaster.setProductid(poref.getProductid());

	 	  promaster.setProductheadid(poref.getProductheadid());
	 	
	 	  promaster.setProductsubheadid(poref.getProductsabheadid());
		
	 	  promaster.setProductname(poref.getProductname()); 

		  promaster.setUnitprice(poref.getUnitprice()); 

		  promaster.setProducttypeid(poref.getProducttypeid());

	 	  promaster.setUnittypeid(poref.getUnittypeid()) ;

	 	  promaster.setCurrencyid_sc(poref.getCurrencyid()) ;

	 	  promaster.setCostprice(poref.getCostprice()) ;

	 	  promaster.setProductcode(poref.getProductcode()); 

	 	  promaster.setDescription(poref.getDescription()) ;

	 	  promaster.setServiceable(poref.getServiceable()) ;

	 	  promaster.setProductcategory(poref.getProductcategory()); 

	 	  promaster.setIsactive(poref.getIsactive());
	 	
	 	  promaster.setSellingprice(poref.getSellingprice());

	      promaster.setColor(poref.getColor());
	      
	      
	      masterProductDao.saveproductdetail(promaster);
	}

	@Override
	public ProductMasterBean getProductById(int id) {
		ProductMaster promst=masterProductDao.getProductById(id);
		
		ProductMasterBean bean=new ProductMasterBean();
		
		bean.setProductid(promst.getProductid());

	 	  bean.setProductheadid(promst.getProductheadid());
	 	
	 	  bean.setProductsabheadid(promst.getProductsubheadid());
		
	 	  bean.setProductname(promst.getProductname()); 

		  bean.setUnitprice(promst.getUnitprice()); 

		  bean.setProducttypeid(promst.getProducttypeid());

	 	  bean.setUnittypeid(promst.getUnittypeid()) ;

	 	  bean.setCurrencyid(promst.getCurrencyid_sc()) ;

	 	  bean.setCostprice(promst.getCostprice()) ;

	 	  bean.setProductcode(promst.getProductcode()); 

	 	  bean.setDescription(promst.getDescription()) ;

	 	 if(promst.getServiceable().equals("Y")){
	 		bean.setServiceable("Yes") ;
		 	  }else{
		 		 bean.setServiceable("No") ;
		 	  }

	 	  bean.setProductcategory(promst.getProductcategory()); 

	 	 if(promst.getIsactive().equals("Y")){
	 		bean.setIsactive("Yes");
		 	  }else{
		 		 bean.setIsactive("No");
		 	  }
	 	
	 	  bean.setSellingprice(promst.getSellingprice());

	      bean.setColor(promst.getColor());
	      
		return bean;
	}

	@Override
	public ProductSubHeadBean getproductsubheadbyid(Integer productsabheadid) {
		ProductSubHead subhead=masterProductDao.getproductsubheadbyid(productsabheadid);
		ProductSubHeadBean subheadbean=new ProductSubHeadBean();
		subheadbean.setProductheadid(subhead.getProductheadid());
		subheadbean.setProductsubheadid(subhead.getProductsubheadid());
		subheadbean.setProductsubheadname(subhead.getProductsubheadname());
		return subheadbean;
	}

	@Override
	@Transactional
	public void editProductById(ProductMasterBean editpro) {
		ProductMaster bean=new ProductMaster();
		
		bean.setProductid(editpro.getProductid());

	 	  bean.setProductheadid(editpro.getProductheadid());
	 	
	 	  bean.setProductsubheadid(editpro.getProductsabheadid());
		
	 	  bean.setProductname(editpro.getProductname()); 

		  bean.setUnitprice(editpro.getUnitprice()); 

		  bean.setProducttypeid(editpro.getProducttypeid());

	 	  bean.setUnittypeid(editpro.getUnittypeid()) ;

	 	  bean.setCurrencyid_sc(editpro.getCurrencyid()) ;

	 	  bean.setCostprice(editpro.getCostprice()) ;

	 	  bean.setProductcode(editpro.getProductcode()); 

	 	  bean.setDescription(editpro.getDescription()) ;

	 	  bean.setServiceable(editpro.getServiceable()) ;

	 	  bean.setProductcategory(editpro.getProductcategory()); 

	 	  bean.setIsactive(editpro.getIsactive());
	 	
	 	  bean.setSellingprice(editpro.getSellingprice());

	      bean.setColor(editpro.getColor());
	      
	      masterProductDao.editProductById(bean);
		
	}

	
	
}
