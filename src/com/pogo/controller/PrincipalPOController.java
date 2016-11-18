package com.pogo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.pogo.bean.JsonArraytoJson;
import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.PoRefEntryItemDetailCopyBean;
import com.pogo.bean.ProductMasterBean;
import com.pogo.model.PoRefEntryItemDetailCopy;
import com.pogo.service.PrinicipalPoService;


@Controller
public class PrincipalPOController {
	
	@Autowired
	private PrinicipalPoService prinicipalposervice;

@RequestMapping(value = "/getpartno", method = RequestMethod.GET)
public void getProductPartNumber(@RequestParam("word") String word, HttpServletResponse res,ProductMasterBean productmasetr) {
	word="a";
	productmasetr.setProductname(word);
	
	String getpart=prinicipalposervice.getPartNo(productmasetr);
    System.out.println(getpart);
    //JsonObject obj = new JsonObject();
	//HttpSession sessiongetpart=res.getSession();
	//sessiongetpart.setAttribute("getpartnumber",getpart);
    try {
		res.getWriter().print(getpart);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
    //ModelAndView model=new ModelAndView();
	//return model;
	}

@RequestMapping(value = "/getpartdetail", method = RequestMethod.GET)
public void getProductDetail(@RequestParam("pro") String pro, HttpServletResponse res,ProductMasterBean productmasetr) {
	//pro="b";
	productmasetr.setProductname(pro);
	System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%     "+pro);
	String getpart=prinicipalposervice.getproductDetail(productmasetr);
    System.out.println(getpart);
    String getpart1=getpart.replaceAll("\\[", "");
	getpart1=getpart1.replaceAll("\\]", "");
   System.out.println(getpart1); 
   try {
		res.getWriter().print(getpart1);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
   
	}


@RequestMapping(value = "/savepodetails", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")

public ModelAndView savePoDetails(@ModelAttribute("productadd")  PoRefEntryItemDetailCopyBean porefitem, HttpServletRequest res,BindingResult result) {
	String val=res.getParameter("dataTodata");
	System.out.println("^^^^^^^^^^^^^^^^^^^^^     DATE              ^&^^^^^^^^^^^^^^^^^^^       "+val);
	PoRefEntryItemDetailCopy poRefEntry = prepareModel(porefitem);
	//PoRefEntryItemDetailCopy poRefEntrycopy = prepareModelCopy(porefitem);
	prinicipalposervice.addPoProduct(poRefEntry);
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("prolist",  prepareListofBean(prinicipalposervice.proList(res)));
	model.put("total", prinicipalposervice.getGrantTotal(res));
	return new ModelAndView("savepro", model);

}

@RequestMapping(value="savedatadb",method=RequestMethod.POST)
@ResponseBody
public void addProductUsingAjax(@RequestBody String json,Model model) throws IOException{
System.out.println(json);
	//ObjectMapper mapper=new ObjectMapper();
	/*PoRefEntryItemDetailCopyBean poref=mapper.readValue(json, PoRefEntryItemDetailCopyBean.class);
	PoRefEntryItemDetailCopyBean poref1=new PoRefEntryItemDetailCopyBean();
	poref1.setParticular(poref.getParticular());
	poref1.setProductdescription(poref.getProductdescription());
	poref1.setTpinjpy(poref.getTpinjpy());
	poref1.setQty(poref.getQty());
	poref1.setTotaljpy(poref.getTotaljpy());
	poref1.setCustomerporefe(poref.getCustomerporefe());
	poref1.setPorefentryitemdetailid(poref.getPorefentryitemdetailid());*/
	
	//poref.setPorefentryitemdetailid(null);
	
	
	//PoRefEntryItemDetailCopy poRefEntry = prepareModel(poref1);
	//prinicipalposervice.addPoProduct(poRefEntry);
	//model.addAttribute("prolist",  prepareListofBean(prinicipalposervice.proList()));
//return toJson(poRefEntry);

Gson gson=new Gson();

JsonArraytoJson [] js=gson.fromJson(json, JsonArraytoJson[].class);
PoRefEntryItemDetailBean poref=new PoRefEntryItemDetailBean();
System.out.println(js.length);
List<String> lst=new ArrayList<String>();
for(JsonArraytoJson e:js){
	System.out.println(e.getName()+"\t\t\t\t<><><><><><><><>\t"+e.getValue());
	lst.add(e.getValue());
}

}




@RequestMapping(value="/prolist", method = RequestMethod.GET)
public ModelAndView proList(@ModelAttribute("productadd")  PoRefEntryItemDetailCopyBean porefitem,
		BindingResult result,HttpServletRequest res) {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("prolist",  prepareListofBean(prinicipalposervice.proList(res)));
	return new ModelAndView("savepro", model);
}
@RequestMapping(value = "/deleteproduct", method = RequestMethod.GET)
public ModelAndView deleteProduct(@ModelAttribute("productadd")  PoRefEntryItemDetailCopyBean porefitem,
		BindingResult result,HttpServletRequest res) {
	prinicipalposervice.deleteProduct(prepareModel(porefitem));
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("product", null);
	model.put("prolist",  prepareListofBean(prinicipalposervice.proList(res)));
	return new ModelAndView("savepro", model);
}
@RequestMapping(value = "/editproduct", method = RequestMethod.GET)
public ModelAndView editProduct(@ModelAttribute("productadd")  PoRefEntryItemDetailCopyBean poref,
		BindingResult result,HttpServletRequest res) {
	Map<String, Object> model = new HashMap<String, Object>();
	List<PoRefEntryItemDetailCopy> productEdit =prinicipalposervice.getProductEdit(poref.getPorefentryitemdetailid());
	PoRefEntryItemDetailCopyBean proedit=prepareProductBean( productEdit);
	model.put("product", proedit);
	model.put("prolist",  prepareListofBean(prinicipalposervice.proList(res)));
	return new ModelAndView("savepro", model);
}


@RequestMapping(value = "/getviewproduct", method = RequestMethod.POST)
public ModelAndView viewProduct(@ModelAttribute("productadd")  PoRefEntryItemDetailCopy poref,
		BindingResult result) {
	Map<String, Object> model = new HashMap<String, Object>();
	//prinicipalposervice.viewPo();
	
	
	//PoRefEntryItemDetailBean proedit=prepareProductBean( productEdit);
	//model.put("product", proedit);
	//model.put("prolist",  prepareListofBean(prinicipalposervice.proList()));
	return new ModelAndView("savepro");
}




private PoRefEntryItemDetailCopyBean prepareProductBean(List<PoRefEntryItemDetailCopy> productEdit) {
	PoRefEntryItemDetailCopyBean poref =new PoRefEntryItemDetailCopyBean();
	
	for(PoRefEntryItemDetailCopy productEdit1:productEdit){
	poref.setProductdescription(productEdit1.getProductdescription());
	poref.setTpinjpy(productEdit1.getTpinjpy());
	poref.setQty(productEdit1.getQty());
	poref.setTotaljpy(productEdit1.getTotaljpy());
	poref.setCustomerporefe(productEdit1.getCustomerporefe());
	poref.setParticular(productEdit1.getParticular());
	poref.setPorefentryitemdetailid(productEdit1.getPorefentryitemdetailid());
	}
	return poref;
}


private PoRefEntryItemDetailCopyBean prepareProductBeanCopy(List<PoRefEntryItemDetailCopy> productEdit) {
	PoRefEntryItemDetailCopyBean poref =new PoRefEntryItemDetailCopyBean();
	
	for(PoRefEntryItemDetailCopy productEdit1:productEdit){
	poref.setProductdescription(productEdit1.getProductdescription());
	poref.setTpinjpy(productEdit1.getTpinjpy());
	poref.setQty(productEdit1.getQty());
	poref.setTotaljpy(productEdit1.getTotaljpy());
	poref.setCustomerporefe(productEdit1.getCustomerporefe());
	poref.setParticular(productEdit1.getParticular());
	poref.setPorefentryitemdetailid(productEdit1.getPorefentryitemdetailid());
	}
	return poref;
}


private PoRefEntryItemDetailCopy prepareModel(PoRefEntryItemDetailCopyBean porefitem) {
	PoRefEntryItemDetailCopy poref=new PoRefEntryItemDetailCopy();
	
	System.out.println(porefitem.getPorefentryitemdetailid());
	poref.setParticular(porefitem.getParticular());
	poref.setProductdescription(porefitem.getProductdescription());
	poref.setTpinjpy(porefitem.getTpinjpy());
	poref.setQty(porefitem.getQty());
	poref.setTotaljpy(porefitem.getTotaljpy());
	poref.setCustomerporefe(porefitem.getCustomerporefe());
	poref.setPorefentryitemdetailid(porefitem.getPorefentryitemdetailid());
	
	porefitem.setPorefentryitemdetailid(null);
	//poref.setPorefentrycopy(porefitem);;
	
	return poref;
}

private PoRefEntryItemDetailCopy prepareModelCopy(PoRefEntryItemDetailCopyBean porefitem) {
	PoRefEntryItemDetailCopy poref=new PoRefEntryItemDetailCopy();
	System.out.println(porefitem.getPorefentryitemdetailid());
	poref.setParticular(porefitem.getParticular());
	poref.setProductdescription(porefitem.getProductdescription());
	poref.setTpinjpy(porefitem.getTpinjpy());
	poref.setQty(porefitem.getQty());
	poref.setTotaljpy(porefitem.getTotaljpy());
	poref.setCustomerporefe(porefitem.getCustomerporefe());
	poref.setPorefentryitemdetailid(porefitem.getPorefentryitemdetailid());
	porefitem.setPorefentryitemdetailid(null);
	
	return poref;
}
private List<PoRefEntryItemDetailCopyBean> prepareListofBean(List<PoRefEntryItemDetailCopy> prodel){
	List<PoRefEntryItemDetailCopyBean> beans = null;
	if(prodel != null && !prodel.isEmpty()){
		beans = new ArrayList<PoRefEntryItemDetailCopyBean>();
		PoRefEntryItemDetailCopyBean bean = null;
		for(PoRefEntryItemDetailCopy pro : prodel){
			bean = new PoRefEntryItemDetailCopyBean();
			bean.setParticular(pro.getParticular());
			bean.setProductdescription(pro.getProductdescription());
			bean.setTpinjpy(pro.getTpinjpy());
			bean.setQty(pro.getQty());
			bean.setTotaljpy(pro.getTotaljpy());
			bean.setCustomerporefe(pro.getCustomerporefe());
			bean.setPorefentryitemdetailid(pro.getPorefentryitemdetailid());
			beans.add(bean);
		}
	}
	return beans;
}

private List<PoRefEntryItemDetailCopyBean> prepareListofBeanCopy(List<PoRefEntryItemDetailCopy> prodel){
	List<PoRefEntryItemDetailCopyBean> beans = null;
	if(prodel != null && !prodel.isEmpty()){
		beans = new ArrayList<PoRefEntryItemDetailCopyBean>();
		PoRefEntryItemDetailCopyBean bean = null;
		for(PoRefEntryItemDetailCopy pro : prodel){
			bean = new PoRefEntryItemDetailCopyBean();
			bean.setParticular(pro.getParticular());
			bean.setProductdescription(pro.getProductdescription());
			bean.setTpinjpy(pro.getTpinjpy());
			bean.setQty(pro.getQty());
			bean.setTotaljpy(pro.getTotaljpy());
			bean.setCustomerporefe(pro.getCustomerporefe());
			bean.setPorefentryitemdetailid(pro.getPorefentryitemdetailid());
			beans.add(bean);
		}
	}
	return beans;
}

}