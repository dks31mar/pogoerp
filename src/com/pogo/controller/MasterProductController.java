package com.pogo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pogo.bean.CurrencyBean;
import com.pogo.bean.ProductHeadBean;
import com.pogo.bean.ProductMasterBean;
import com.pogo.bean.ProductSubHeadBean;
import com.pogo.bean.ServiceProviderBean;
import com.pogo.bean.UnitBean;
import com.pogo.service.MasterProductService;
/*
 * Master product
 * 
 * by dks
 * */

@Controller
public class MasterProductController {

	@Autowired
	private MasterProductService masterProductService;
	
	
	
	@RequestMapping(value="/currency",method = RequestMethod.GET)
	public ModelAndView getCurrency(@ModelAttribute("currencyBean") CurrencyBean currencyBean,
			HttpServletRequest request){
		List<CurrencyBean> list=new ArrayList<CurrencyBean>();
		list=masterProductService.getCurrencyDetails();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("currencylist", list);
		
			
		
		return new ModelAndView("currency",model);
}
	
	
	@RequestMapping(value="savecurrency",method=RequestMethod.POST)
	@ResponseBody
	public String addCurrency(@RequestBody String json,Model model) throws IOException{
	System.out.println(json);
		ObjectMapper mapper=new ObjectMapper();
		CurrencyBean poref=mapper.readValue(json, CurrencyBean.class);
		CurrencyBean poref1=new CurrencyBean();
		poref1.setCurrencyname(poref.getCurrencyname());
		poref1.setCurrencysymbol(poref.getCurrencysymbol());
		poref1.setCurrencytype(poref.getCurrencytype());
		
		//poref.setPorefentryitemdetailid(null);
		
		
		
		masterProductService.addCurrency(poref1);
		//model.addAttribute("prolist",  prepareListofBean(prinicipalposervice.proList()));
	return toJson(poref1);
	}

	private String toJson(CurrencyBean poRefEntry) {
		ObjectMapper mapper = new ObjectMapper();
	    try {
	        String value = mapper.writeValueAsString(poRefEntry);
	        // return "["+value+"]";
	        return value;
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	

	@RequestMapping(value = "deletecurrency", method = RequestMethod.GET)
	public ModelAndView deleteuserCurrencyData(@RequestParam("id") int id) {
		masterProductService.deleteCurrency(id);
		List<CurrencyBean> list=new ArrayList<CurrencyBean>();
		list=masterProductService.getCurrencyDetails();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("currencylist", list);
		
			
		
		return new ModelAndView("currency",model);
	}
	
	
	@RequestMapping(value = "getcurrency", method = RequestMethod.POST)
	public void getCurrency(@RequestParam("id") String id,HttpServletResponse res )throws ParseException  {
		String curList=masterProductService.getCurrency(id);
		System.out.println(curList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(curList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	@RequestMapping(value="editcurrency",method=RequestMethod.POST)
	@ResponseBody
	public String editCurrency(@RequestBody String json,Model model) throws IOException{
	System.out.println("Deeoak              *****************************************************");
		ObjectMapper mapper=new ObjectMapper();
		CurrencyBean poref=mapper.readValue(json, CurrencyBean.class);
		CurrencyBean poref1=new CurrencyBean();
		poref1.setCurrencyid(poref.getCurrencyid());
		poref1.setCurrencyname(poref.getCurrencyname());
		poref1.setCurrencysymbol(poref.getCurrencysymbol());
		poref1.setCurrencytype(poref.getCurrencytype());
		
		//poref.setPorefentryitemdetailid(null);
		
		
		
		masterProductService.editCurrency(poref1);
		//model.addAttribute("prolist",  prepareListofBean(prinicipalposervice.proList()));
	return toJson1(poref1);
	}

	private String toJson1(CurrencyBean poRefEntry) {
		ObjectMapper mapper = new ObjectMapper();
	    try {
	        String value = mapper.writeValueAsString(poRefEntry);
	        // return "["+value+"]";
	        return value;
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	@RequestMapping(value="/unit",method = RequestMethod.GET)
	public ModelAndView getUnits(@ModelAttribute("unitBean") UnitBean currencyBean,
			HttpServletRequest request){
		List<UnitBean> list=new ArrayList<UnitBean>();
		list=masterProductService.getUnitsDetails();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("unitlist", list);
		return new ModelAndView("getunit",model);
}
	
	
	@RequestMapping(value="addunit",method=RequestMethod.POST)
	@ResponseBody
	public void addUnit(@RequestBody String json,Model model) throws IOException{
	System.out.println("Deeoak              ***************************************************** \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		UnitBean poref=mapper.readValue(json, UnitBean.class);
		UnitBean poref1=new UnitBean();
		//poref1.setCurrencyid(poref.getCurrencyid());
		poref1.setUnittype(poref.getUnittype());
		
		//poref.setPorefentryitemdetailid(null);
		
		
		
		masterProductService.addUnit(poref1);
		//model.addAttribute("prolist",  prepareListofBean(prinicipalposervice.proList()));
	//return toJson1(poref1);
	}
	
	@RequestMapping(value = "deleteunit", method = RequestMethod.GET)
	public ModelAndView deleteUnitData(@RequestParam("id") int id) {
		masterProductService.deleteUnit(id);
		List<UnitBean> list=new ArrayList<UnitBean>();
		list=masterProductService.getUnitsDetails();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("unitlist", list);
		return new ModelAndView("getunit",model);
	}
	
	
	
	@RequestMapping(value = "getunit", method = RequestMethod.POST)
	public void getUnit(@RequestParam("id") String id,HttpServletResponse res )throws ParseException  {
		String curList=masterProductService.getUnitById(id);
		System.out.println(curList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(curList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	
	
	@RequestMapping(value="editunit",method=RequestMethod.POST)
	@ResponseBody
	public void editUnit(@RequestBody String json,Model model) throws IOException{
	System.out.println("Deeoak              *****************************************************");
		ObjectMapper mapper=new ObjectMapper();
		UnitBean poref=mapper.readValue(json, UnitBean.class);
		UnitBean poref1=new UnitBean();
		poref1.setUnittypeid(poref.getUnittypeid());
		poref1.setUnittype(poref.getUnittype());
		
		masterProductService.editUnit(poref1);
		
	}

	
	
	@RequestMapping(value="/producthead",method = RequestMethod.GET)
	public ModelAndView getProductHead(@ModelAttribute("producthead") ProductHeadBean productHeadBean,
			HttpServletRequest request){
		List<ProductHeadBean> list=new ArrayList<ProductHeadBean>();
		list=masterProductService.getProductHeadDetails();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("productlist", list);
		return new ModelAndView("productheadpage",model);
}

	
	@RequestMapping(value="addproduct",method=RequestMethod.POST)
	@ResponseBody
	public void addProducthead(@RequestBody String json,Model model) throws IOException{
	System.out.println("Deeoak              ***************************************************** \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		ProductHeadBean poref=mapper.readValue(json, ProductHeadBean.class);
		ProductHeadBean poref1=new ProductHeadBean();
		//poref1.setCurrencyid(poref.getCurrencyid());
		poref1.setProductheadname(poref.getProductheadname());
		
		//poref.setPorefentryitemdetailid(null);
		
		
		
		masterProductService.addProductHead(poref1);
		//model.addAttribute("prolist",  prepareListofBean(prinicipalposervice.proList()));
	//return toJson1(poref1);
	}
	
	
	
	@RequestMapping(value = "deleteproducthead", method = RequestMethod.GET)
	public ModelAndView deleteProductHeadData(@RequestParam("id") int id) {
		masterProductService.deleteProductHead(id);
		List<ProductHeadBean> list=new ArrayList<ProductHeadBean>();
		list=masterProductService.getProductHeadDetails();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("productlist", list);
		return new ModelAndView("productheadpage",model);
	}
	
	
	@RequestMapping(value="editproducthead",method=RequestMethod.POST)
	@ResponseBody
	public void editProducthead(@RequestBody String json,Model model) throws IOException{
	System.out.println("Deeoak              *****************************************************");
	ObjectMapper mapper=new ObjectMapper();
	ProductHeadBean poref=mapper.readValue(json, ProductHeadBean.class);
	ProductHeadBean poref1=new ProductHeadBean();
	//poref1.setCurrencyid(poref.getCurrencyid());
	poref1.setProductheadname(poref.getProductheadname());
	poref1.setProductheadid(poref.getProductheadid());	
		masterProductService.editProductHead(poref1);
		
	}
	
	
	
	@RequestMapping(value = "getproducthead", method = RequestMethod.POST)
	public void getProductheadByID(@RequestParam("id") String id,HttpServletResponse res )throws ParseException  {
		String curList=masterProductService.getProductHeadById(id);
		System.out.println(curList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(curList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	

	@RequestMapping(value="/productsubhead",method = RequestMethod.GET)
	public ModelAndView ProductSubHead(@ModelAttribute("producthead") ProductHeadBean productHeadBean,
			HttpServletRequest request){
		List<ProductHeadBean> list=new ArrayList<ProductHeadBean>();
		list=masterProductService.getProductHeadDetails();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("productlist", list);
		
		
		return new ModelAndView("productsubheadpage",model);
}

	
	@RequestMapping(value="addproductSub",method=RequestMethod.POST)
	@ResponseBody
	public void addProductSubhead(@RequestBody String json,Model model) throws IOException{
	System.out.println("Deeoak              ***************************************************** \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		ProductSubHeadBean poref=mapper.readValue(json, ProductSubHeadBean.class);
		ProductSubHeadBean poref1=new ProductSubHeadBean();
		//poref1.setCurrencyid(poref.getCurrencyid());
		poref1.setProductheadid(poref.getProductheadid());
		poref1.setProductsubheadname(poref.getProductsubheadname());
		
		masterProductService.addProductSubHead(poref1);
	}
	
	@RequestMapping(value="/promaster",method = RequestMethod.GET)
	public ModelAndView MobileAppRegis(@ModelAttribute("producthead") ProductHeadBean productHeadBean,
			HttpServletRequest request){
		List<ProductMasterBean> list=new ArrayList<ProductMasterBean>();
		list=masterProductService.getProDetails();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("prodetail", list);
		
		return new ModelAndView("promaster",model);
}
	
	
	
	@RequestMapping(value = "deleteprodet", method = RequestMethod.GET)
	public ModelAndView deleteProductData(@RequestParam("id") int id) {
		masterProductService.deleteProductData(id);
		List<ProductMasterBean> list=new ArrayList<ProductMasterBean>();
		list=masterProductService.getProDetails();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("prodetail", list);
		
		return new ModelAndView("promaster",model);
	}
	
	
	
	@RequestMapping(value = "searchproduct", method = RequestMethod.POST)
	public @ResponseBody String filterEmpployee(@RequestParam String proname)
			throws JsonProcessingException {
		List<ProductMasterBean> userbean = masterProductService.searchProductbynameandcode(proname);
		ObjectMapper map = new ObjectMapper();
		return map.writeValueAsString(userbean);
	}
	
	
	@RequestMapping(value = "deletesearchprodet", method = RequestMethod.GET)
	public void deleteSearchProductData(@RequestParam("id") int id,HttpServletResponse req) {
		masterProductService.deleteProductData(id);
		
		try {
			req.getWriter().print("true");
		} catch (IOException e) {
			
			e.printStackTrace();
		};
		
		//return new ModelAndView("promaster",model);
	}
	
	
	

	@RequestMapping(value="/getaddproductpage",method = RequestMethod.GET)
	public ModelAndView addProductPage(@ModelAttribute("currencyBean") CurrencyBean currencyBean,
			HttpServletRequest request){
		List<CurrencyBean> curency=new ArrayList<CurrencyBean>();
		curency=masterProductService.getCurrencyDetails();
		List<UnitBean> unit=new ArrayList<UnitBean>();
		unit=masterProductService.getUnitsDetails();
		List<ProductHeadBean> producthead=new ArrayList<ProductHeadBean>();
		producthead=masterProductService.getProductHeadDetails();
		List<ProductSubHeadBean> productsubhead=new ArrayList<ProductSubHeadBean>();
		productsubhead=masterProductService.getProductSubHead();
		Map<String, Object> model= new HashMap<String,Object>();	
		model.put("currencylist", curency);
		model.put("unitlist", unit);
		model.put("productlist", producthead);
		model.put("subproductlist", productsubhead);
		
		
		return new ModelAndView("getaddproductpage",model);
}
	@RequestMapping(value="saveproductdet",method=RequestMethod.POST)
	@ResponseBody
	public void addProduct(@RequestBody String json,Model model) throws IOException{
	System.out.println("Deeoak              ***************************************************** \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		ProductMasterBean poref=mapper.readValue(json, ProductMasterBean.class);
		
		masterProductService.addProduct(poref);
	}
	
	
	
	@RequestMapping(value = "/editproductdata", method = RequestMethod.GET)
	public ModelAndView getProductById(@RequestParam("id") int id, Model model1) throws JsonParseException, JsonMappingException, IOException {
	
		ObjectMapper mapper=new ObjectMapper();
		List<CurrencyBean> curency=new ArrayList<CurrencyBean>();
		curency=masterProductService.getCurrencyDetails();
		List<UnitBean> unit=new ArrayList<UnitBean>();
		unit=masterProductService.getUnitsDetails();
		List<ProductHeadBean> producthead=new ArrayList<ProductHeadBean>();
		producthead=masterProductService.getProductHeadDetails();
		List<ProductSubHeadBean> productsubhead=new ArrayList<ProductSubHeadBean>();
		productsubhead=masterProductService.getProductSubHead();
		Map<String, Object> model= new HashMap<String,Object>();	
		model.put("currencylist", curency);
		model.put("unitlist", unit);
		model.put("productlist", producthead);
		model.put("subproductlist", productsubhead);
		
		ProductMasterBean bean=masterProductService.getProductById(id);
		System.out.println(bean.getProductheadid());
		System.out.println(bean.getProductsabheadid());
		System.out.println(bean.getCurrencyid());
		System.out.println(bean.getUnittypeid());
		
		String proheadid=Integer.toString(bean.getProductheadid());
		
		String currency=masterProductService.getCurrency(bean.getCurrencyid());
		String unitb=masterProductService.getUnitById(bean.getUnittypeid());
		String prohead=masterProductService.getProductHeadById(proheadid);
		
		ProductSubHeadBean prosubhead=masterProductService.getproductsubheadbyid(bean.getProductsabheadid());
		
		CurrencyBean curbean=mapper.readValue(currency, CurrencyBean.class);
		UnitBean unitbean=mapper.readValue(unitb, UnitBean.class);
		ProductHeadBean proheadbean=mapper.readValue(prohead, ProductHeadBean.class);
		
		
		model1.addAttribute("product", bean);
		model1.addAttribute("curr", curbean);
		model1.addAttribute("uintt",unitbean);
		model1.addAttribute("prohead", proheadbean);
		model1.addAttribute("prosubhead", prosubhead);
		
		return new ModelAndView("editproductdata",model);
	}
	
	@RequestMapping(value="updateproductdata",method=RequestMethod.POST)
	@ResponseBody
	public void editProductById(@RequestBody String json,Model model) throws IOException{
	System.out.println("*****************************************************\n"+json);
		ObjectMapper mapper=new ObjectMapper();
		ProductMasterBean editpro=mapper.readValue(json, ProductMasterBean.class);
		
		masterProductService.editProductById(editpro);
		
	
	}
	
}
