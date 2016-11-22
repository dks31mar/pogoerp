package com.pogo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.google.gson.Gson;
import com.pogo.bean.JsonArraytoJson;
import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.PoRefEntryItemDetailCopyBean;
import com.pogo.bean.PorefSupplierDetailBean;
import com.pogo.bean.ProductMasterBean;
import com.pogo.model.PoRefEntryItemDetailCopy;
import com.pogo.service.PrinicipalPoService;


@Controller
public class PrincipalPOController {
	
	@Autowired
	private PrinicipalPoService prinicipalposervice;

@RequestMapping(value = "/getpartno", method = RequestMethod.GET)
public void getProductPartNumber(@RequestParam("word") String word, HttpServletResponse res,ProductMasterBean productmasetr) {
	
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
	//PoRefEntryItemDetailCopy poRefEntry = prepareModel(porefitem);
	//PoRefEntryItemDetailCopy poRefEntrycopy = prepareModelCopy(porefitem);
	//prinicipalposervice.addPoProduct(poRefEntry);
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("prolist",  prepareListofBean(prinicipalposervice.proList(res)));
	model.put("total", prinicipalposervice.getGrantTotal(res));
	return new ModelAndView("savepro", model);

}

@RequestMapping(value="savedatadb",method=RequestMethod.POST)
@ResponseBody
public void addProductUsingAjax(@RequestBody String json,Model model) throws IOException{
	System.out.println(json);
	Gson gson=new Gson();
	JsonArraytoJson [] js=gson.fromJson(json, JsonArraytoJson[].class);
	System.out.println(js.length);
	List<String> lst=new ArrayList<String>();
		for(JsonArraytoJson e:js){
			System.out.println(e.getName()+"\t\t\t\t<><><><><><><><>\t"+e.getValue());
			lst.add(e.getValue());
			}
	System.out.println(lst.size());
	String [] meth=lst.toArray(new String[lst.size()]);

		for(int i=0;i<meth.length;i=i+11){
			
			PoRefEntryItemDetailBean poref=new PoRefEntryItemDetailBean();
			PorefSupplierDetailBean porefs=new PorefSupplierDetailBean();
			
			porefs.setPorefdate(meth[i]);
			porefs.setPorefno(meth[i+1]);
			poref.setParticular(meth[i+2]);
			poref.setProductdescription(meth[i+3]);
			poref.setTpinjpy(meth[i+4]);
			poref.setQty(Double.parseDouble(meth[i+5]));
			poref.setTotaljpy(Double.parseDouble(meth[i+6]));
			poref.setCustomerporefe(meth[i+7]);
			porefs.setTotal(Double.parseDouble(meth[8]));
			System.out.println();
			System.out.println(i+"     <<<<<<<<<<<<<<<<<<<<<");
			
			if(i==0){
				System.out.println("inside if    "+i);
				prinicipalposervice.addPoSupplier(porefs);
				prinicipalposervice.addPoProduct(poref,porefs);
				
			}else{
				prinicipalposervice.addPoProduct(poref,porefs);
				}
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
	//Map<String, Object> model = new HashMap<String, Object>();
	//prinicipalposervice.viewPo();
	
	
	//PoRefEntryItemDetailBean proedit=prepareProductBean( productEdit);
	//model.put("product", proedit);
	//model.put("prolist",  prepareListofBean(prinicipalposervice.proList()));
	return new ModelAndView("savepro");
}

@RequestMapping(value="/getviewpo",method = RequestMethod.GET)
public ModelAndView getView( @ModelAttribute("command") PorefSupplierDetailBean porefitem,HttpServletRequest request,BindingResult result){
	System.out.println("in get view method");
	List<PorefSupplierDetailBean> lst =new ArrayList<>();
	lst=prinicipalposervice.getSupplierlist();
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("viewlist", lst);
return new ModelAndView("viewpo",model);
}
@RequestMapping(value="/editpo",method = RequestMethod.GET)
public ModelAndView getEditPoDetails(@RequestParam("poref") String poref, @ModelAttribute("command") PorefSupplierDetailBean porefitem,HttpServletRequest request,BindingResult result,Model m){
	System.out.println("in get edit method");
	List<PoRefEntryItemDetailBean> lst =new ArrayList<>();
	lst=prinicipalposervice.getPoDetailByPorefNo(poref);
	System.out.println(lst);
	double total=0.0;
	String date=null;
	String porefNo=null;
	for(PoRefEntryItemDetailBean g:lst){
		System.out.println(g.getPorefnobysupplier().getTotal());
		total=g.getPorefnobysupplier().getTotal();
		date=g.getPorefnobysupplier().getPorefdate();
		porefNo=g.getPorefnobysupplier().getPorefno();
	}
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("listbyporef", lst);
	m.addAttribute("gtotal", total);
	m.addAttribute("date", date);
	m.addAttribute("porefnumber", porefNo);
return new ModelAndView("edit",model);
}



@RequestMapping(value="updatedatadb",method=RequestMethod.POST)
@ResponseBody
public void updateProductUsingAjax(@RequestBody String json,Model model) throws IOException{
	System.out.println(json);
	Gson gson=new Gson();
	JsonArraytoJson [] js=gson.fromJson(json, JsonArraytoJson[].class);
	System.out.println(js.length);
	List<String> lst=new ArrayList<String>();
		for(JsonArraytoJson e:js){
			System.out.println(e.getName()+"\t\t\t\t<><><><><><><><>\t"+e.getValue());
			lst.add(e.getValue());
			}
	System.out.println(lst.size());
	String [] meth=lst.toArray(new String[lst.size()]);

		for(int i=0;i<meth.length;i=i+12){
			
			PoRefEntryItemDetailBean poref=new PoRefEntryItemDetailBean();
			PorefSupplierDetailBean porefs=new PorefSupplierDetailBean();
			
			porefs.setPorefdate(meth[i]);
			porefs.setPorefno(meth[i+1]);
			System.out.println(meth[i+2]);
			if(meth[i+2].isEmpty()==false){
				System.out.println(")()()()()()()()()()()()()()()()()()()()()()()()()()(                     ");
				poref.setPorefentryitemdetailid(Integer.parseInt(meth[i+2]));
			}
			
			poref.setParticular(meth[i+3]);
			poref.setProductdescription(meth[i+4]);
			poref.setTpinjpy(meth[i+5]);
			poref.setQty(Double.parseDouble(meth[i+6]));
			poref.setTotaljpy(Double.parseDouble(meth[i+7]));
			poref.setCustomerporefe(meth[i+8]);
			porefs.setTotal(Double.parseDouble(meth[9]));
			System.out.println();
			System.out.println(i+"     <<<<<<<<<<<<<<<<<<<<<");
			
			if(i==0){
				System.out.println("inside if    "+i);
				prinicipalposervice.updatePoSupplier(porefs);
				prinicipalposervice.UpdatePoProduct(poref,porefs);
				
			}else{
				prinicipalposervice.UpdatePoProduct(poref,porefs);
				}
			
			}
			
}

@RequestMapping(value="/printreport",method = RequestMethod.GET)
public ModelAndView printPoDetails(@RequestParam("poref") String poref, @ModelAttribute("command") PorefSupplierDetailBean porefitem,HttpServletRequest request,BindingResult result,Model m){
	System.out.println("in get edit method");
	List<PoRefEntryItemDetailBean> lst =new ArrayList<>();
	lst=prinicipalposervice.getPoDetailByPorefNo(poref);
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>      "+lst);
	double total=0.0;
	String date=null;
	String porefNo=null;
	for(PoRefEntryItemDetailBean g:lst){
		System.out.println(g.getPorefnobysupplier().getTotal());
		total=g.getPorefnobysupplier().getTotal();
		date=g.getPorefnobysupplier().getPorefdate();
		porefNo=g.getPorefnobysupplier().getPorefno();
	}
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("listbyporef", lst);
	m.addAttribute("gtotal", total);
	m.addAttribute("date", date);
	m.addAttribute("porefnumber", porefNo);
return new ModelAndView("print",model);
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


/*private PoRefEntryItemDetailCopyBean prepareProductBeanCopy(List<PoRefEntryItemDetailCopy> productEdit) {
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
}*/


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

/*private PoRefEntryItemDetailCopy prepareModelCopy(PoRefEntryItemDetailCopyBean porefitem) {
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
}*/
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

/*private List<PoRefEntryItemDetailCopyBean> prepareListofBeanCopy(List<PoRefEntryItemDetailCopy> prodel){
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
}*/

}