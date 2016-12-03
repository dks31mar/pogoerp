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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.pogo.bean.Book;
import com.pogo.bean.CurrencyBean;
import com.pogo.bean.InvoiceDetailBean;
import com.pogo.bean.InvoiceTabBean;
import com.pogo.bean.JsonArraytoJson;
import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.PoRefEntryItemDetailCopyBean;
import com.pogo.bean.PorefSupplierDetailBean;
import com.pogo.bean.PrinicipalPoPDFBean;
import com.pogo.bean.ProductAcknowledgementBean;
import com.pogo.bean.ProductMasterBean;
import com.pogo.model.InvoiceDetail;
import com.pogo.model.InvoiceTab;
import com.pogo.model.PoRefEntryItemDetailCopy;
import com.pogo.model.PorefSupplierDetail;
import com.pogo.model.ProductAcknowledgement;
import com.pogo.service.CommonService;
import com.pogo.service.PrinicipalPoService;


@Controller
public class PrincipalPOController {
	
	@Autowired
	private PrinicipalPoService prinicipalposervice;
	@Autowired
	private CommonService commonservice;
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

@RequestMapping(value = "/getsupmstdtl", method = RequestMethod.GET)
public void getSupplierDetails(HttpServletResponse res) {

	
	
	String getpart=prinicipalposervice.getSupplierDetails();
    System.out.println(getpart);
    String getpart1=getpart.replaceAll("\\[", "");
	getpart1=getpart1.replaceAll("\\]", "");
   System.out.println(getpart1); 
   try {
		res.getWriter().print(getpart);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
   
	}

@RequestMapping(value = "/getsupmstdtlbyname", method = RequestMethod.GET)
public void getSupplierDetailsByName(@RequestParam("name") String name,HttpServletResponse res) {

	
	
	String getpart=prinicipalposervice.getSupplierDetailsByName(name);
    System.out.println(getpart);
    String getpart1=getpart.replaceAll("\\[", "");
	getpart1=getpart1.replaceAll("\\]", "");
   System.out.println(getpart1); 
   try {
		res.getWriter().print(getpart);
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

		for(int i=0;i<meth.length;i=i+14){
			
			PoRefEntryItemDetailBean poref=new PoRefEntryItemDetailBean();
			PorefSupplierDetailBean porefs=new PorefSupplierDetailBean();
			
			porefs.setPorefdate(meth[i]);
			porefs.setPorefno(meth[i+1]);
			porefs.setPrincipalname(meth[i+2]);
			porefs.setAddress(meth[i+3]);
			porefs.setCurrency(meth[i+4]);
			poref.setParticular(meth[i+5]);
			poref.setProductdescription(meth[i+6]);
			poref.setTpinjpy(meth[i+7]);
			poref.setQty(Double.parseDouble(meth[i+8]));
			poref.setTotaljpy(Double.parseDouble(meth[i+9]));
			poref.setCustomerporefe(meth[i+10]);
			porefs.setTotal(Double.parseDouble(meth[11]));
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
	String pname=null;
	String paddress=null;
	String currencylable=null;
	for(PoRefEntryItemDetailBean g:lst){
		System.out.println(g.getPorefnobysupplier().getTotal());
		total=g.getPorefnobysupplier().getTotal();
		date=g.getPorefnobysupplier().getPorefdate();
		porefNo=g.getPorefnobysupplier().getPorefno();
		pname=g.getPorefnobysupplier().getPrincipalname();
		paddress=g.getPorefnobysupplier().getAddress();
		currencylable=g.getPorefnobysupplier().getCurrency();
	}
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("listbyporef", lst);
	m.addAttribute("gtotal", total);
	m.addAttribute("date", date);
	m.addAttribute("porefnumber", porefNo);
	m.addAttribute("pname",pname);
	m.addAttribute("paddress", paddress);
	m.addAttribute("curlable", currencylable);
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

		for(int i=0;i<meth.length;i=i+14){
			
			PoRefEntryItemDetailBean poref=new PoRefEntryItemDetailBean();
			PorefSupplierDetailBean porefs=new PorefSupplierDetailBean();
			
			porefs.setPorefdate(meth[i]);
			porefs.setPorefno(meth[i+1]);
			System.out.println(meth[i+2]);
			if(meth[i+2].isEmpty()==false){
				System.out.println(")()()()()()()()()()()()()()()()()()()()()()()()()()(                     ");
				poref.setPorefentryitemdetailid(Integer.parseInt(meth[i+2]));
			}
			porefs.setPrincipalname(meth[i+3]);
			porefs.setAddress(meth[i+4]);
			poref.setParticular(meth[i+5]);
			poref.setProductdescription(meth[i+6]);
			poref.setTpinjpy(meth[i+7]);
			poref.setQty(Double.parseDouble(meth[i+8]));
			poref.setTotaljpy(Double.parseDouble(meth[i+9]));
			poref.setCustomerporefe(meth[i+10]);
			porefs.setTotal(Double.parseDouble(meth[11]));
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


@RequestMapping(value="deletepo",method = RequestMethod.POST)
@ResponseBody
public void deletePoById(@RequestBody String json, @ModelAttribute("command") PorefSupplierDetailBean porefitem,HttpServletRequest request,BindingResult result,Model m) throws JsonParseException, JsonMappingException, IOException{

	ObjectMapper mapper=new ObjectMapper();
	PoRefEntryItemDetailBean poref=mapper.readValue(json, PoRefEntryItemDetailBean.class);
	
	prinicipalposervice.deletePoById(Integer.toString(poref.getPorefentryitemdetailid()));
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
	String pname=null;
	String paddress=null;
	for(PoRefEntryItemDetailBean g:lst){
		System.out.println(g.getPorefnobysupplier().getTotal());
		total=g.getPorefnobysupplier().getTotal();
		date=g.getPorefnobysupplier().getPorefdate();
		porefNo=g.getPorefnobysupplier().getPorefno();
		pname=g.getPorefnobysupplier().getPrincipalname();
		paddress=g.getPorefnobysupplier().getAddress();
	}
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("listbyporef", lst);
	m.addAttribute("gtotal", total);
	m.addAttribute("date", date);
	m.addAttribute("porefnumber", porefNo);
	m.addAttribute("pname",pname);
	m.addAttribute("paddress", paddress);
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

@RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
public ModelAndView downloadExcel(@RequestParam("poref") String poref) {
	// create some sample data
	
	List<PoRefEntryItemDetailBean> lst =new ArrayList<>();
	lst=prinicipalposervice.getPoDetailByPorefNo(poref);
	
	List<PrinicipalPoPDFBean> listBooks = new ArrayList<PrinicipalPoPDFBean>();
	int i=0;
	double totlqty=0.0;
	for(PoRefEntryItemDetailBean e:lst){
		totlqty+=e.getQty();
	}
	
	
	for(PoRefEntryItemDetailBean e:lst){
		listBooks.add(new PrinicipalPoPDFBean(++i,e.getProductdescription(),e.getParticular(),e.getTpinjpy(),e.getQty(),e.getTotaljpy(),e.getPorefnobysupplier().getPorefno(),e.getPorefnobysupplier().getPorefdate(),"Deepak",e.getPorefnobysupplier().getAddress(),e.getPorefnobysupplier().getTotal(),totlqty));
	
	}
	
	return new ModelAndView("pdfView", "listBooks", listBooks);
}


@RequestMapping(value="/acknowledgement",method = RequestMethod.GET)
public ModelAndView getacknowledgement( @ModelAttribute("command") PorefSupplierDetailBean porefitem,HttpServletRequest request,BindingResult result){
	System.out.println("in get acknowledgement method");
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("acklist",  prepareViewListofBean(commonservice.viewList()));
return new ModelAndView("acknowledgementView", model);
}


private List<PorefSupplierDetailBean> prepareViewListofBean(List<PorefSupplierDetail> prodel){
	List<PorefSupplierDetailBean> beans = null;
	if(prodel != null && !prodel.isEmpty()){
		beans = new ArrayList<PorefSupplierDetailBean>();
		PorefSupplierDetailBean bean = null;
		for(PorefSupplierDetail pro : prodel){
			bean = new PorefSupplierDetailBean();
			//System.out.println(bean);
			bean.setPorefno(pro.getPorefno());
			System.out.println(bean.getPorefno());
			bean.setPorefdate(pro.getPorefdate());
			System.out.println(bean.getPorefdate());
			bean.setPrincipalname(pro.getPrincipalname());
			bean.setAddress(pro.getAddress());
			beans.add(bean);
		}
	}
	return beans;
}



@RequestMapping(value="/supplierack",method = RequestMethod.GET)
public ModelAndView getacknowledsupplierpo(@RequestParam("poref") String poref,@RequestParam("page") String pagename, @ModelAttribute("command") PorefSupplierDetailBean porefitem,HttpServletRequest request,BindingResult result,Model m){
	System.out.println("in get edit method");
	List<PoRefEntryItemDetailBean> lst =new ArrayList<>();
	lst=prinicipalposervice.getackDetailByPorefNo(poref);
	System.out.println(lst);
	double total=0.0;
	String date=null;
	String porefNo=null;
	String pname=null;
	String paddress=null;
	String currencylable=null;
	for(PoRefEntryItemDetailBean g:lst){
		System.out.println(g.getPorefnobysupplier().getTotal());
		total=g.getPorefnobysupplier().getTotal();
		date=g.getPorefnobysupplier().getPorefdate();
		porefNo=g.getPorefnobysupplier().getPorefno();
		pname=g.getPorefnobysupplier().getPrincipalname();
		paddress=g.getPorefnobysupplier().getAddress();
		currencylable=g.getPorefnobysupplier().getCurrency();
	}
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("listbyporef", lst);
	m.addAttribute("gtotal", total);
	m.addAttribute("date", date);
	m.addAttribute("porefnumber", porefNo);
	m.addAttribute("pname",pname);
	m.addAttribute("paddress", paddress);
	m.addAttribute("curlable", currencylable);
return new ModelAndView("supplierackView",model);

}



@RequestMapping(value="/ackdatabysearch",method = RequestMethod.GET)
public @ResponseBody String getacknowledDataBySearch(@RequestParam("poref") String poref, @ModelAttribute("command") PorefSupplierDetailBean porefitem,HttpServletRequest request,BindingResult result,Model m) throws JsonProcessingException{
	System.out.println("in get edit method");
	List<PoRefEntryItemDetailBean> lst =new ArrayList<>();
	lst=prinicipalposervice.getPoDetailByPorefId(poref);
	ObjectMapper map = new ObjectMapper();
	return map.writeValueAsString(lst);
//return new ModelAndView("supplierackView");
}



@RequestMapping(value="saveackindb",method=RequestMethod.POST)
@ResponseBody
public void saveAcknowledData(@RequestBody String json,Model model) throws IOException{
	System.out.println(""+json);
	
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

	for(int i=0;i<meth.length;i=i+6){
		ProductAcknowledgementBean bean=new ProductAcknowledgementBean();
		bean.setProductacknowledgementid(Integer.parseInt(meth[i]));
		bean.setPorefno(meth[1]);
		bean.setParticular(meth[2]);
		bean.setPendingqty(Double.parseDouble(meth[3]));
		bean.setExpdate(meth[i+4]);
		bean.setReceiveqty(Double.parseDouble(meth[i+5]));
		prinicipalposervice.saveAcknowledData(bean);
	}
	
	/*ObjectMapper mapper=new ObjectMapper();
	ProductAcknowledgementBean bean=mapper.readValue(json, ProductAcknowledgementBean.class);
		prinicipalposervice.saveAcknowledData(bean);	*/
}

@RequestMapping(value="getackdatabypo",method = RequestMethod.POST)
@ResponseBody
public String getAckData(@RequestParam("porefno") String s1,@RequestParam("particular") String s2,@ModelAttribute("command") PorefSupplierDetailBean porefitem,HttpServletRequest request,BindingResult result,Model m) throws JsonProcessingException{
	System.out.println("in get view method");
	List<ProductAcknowledgementBean> lst =new ArrayList<>();
	lst=prinicipalposervice.getAckData(s1,s2);
	
	ObjectMapper map = new ObjectMapper();
	return map.writeValueAsString(lst);

}

@RequestMapping(value="deleteparticularack",method = RequestMethod.POST)
@ResponseBody
public void deleteParticularAck(@RequestParam("aid") String s1,@ModelAttribute("command") PorefSupplierDetailBean porefitem,HttpServletRequest request,BindingResult result,Model m) throws JsonProcessingException{
	System.out.println("in get view method");
	//List<ProductAcknowledgementBean> lst =new ArrayList<>();
	//lst=
			prinicipalposervice.deleteParticularAck(s1);
	
	//ObjectMapper map = new ObjectMapper();
	//return map.writeValueAsString(lst);

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

@RequestMapping(value="/supplierinvoice",method = RequestMethod.GET)
public ModelAndView getsupplierinvoice(@RequestParam("poref") String poref,@RequestParam("page") String page, @ModelAttribute("command") PorefSupplierDetailBean porefitem,HttpServletRequest request,BindingResult result,Model m){
	
	List<PoRefEntryItemDetailBean> lst =new ArrayList<>();
	lst=prinicipalposervice.getInvoiceData(poref);
	System.out.println(lst);
	double total=0.0;
	String date=null;
	String porefNo=null;
	String pname=null;
	String paddress=null;
	String currencylable=null;
	for(PoRefEntryItemDetailBean g:lst){
		System.out.println(g.getPorefnobysupplier().getTotal());
		total=g.getPorefnobysupplier().getTotal();
		date=g.getPorefnobysupplier().getPorefdate();
		porefNo=g.getPorefnobysupplier().getPorefno();
		pname=g.getPorefnobysupplier().getPrincipalname();
		paddress=g.getPorefnobysupplier().getAddress();
		currencylable=g.getPorefnobysupplier().getCurrency();
	}
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("listbyporef", lst);
	m.addAttribute("gtotal", total);
	m.addAttribute("date", date);
	m.addAttribute("porefnumber", porefNo);
	m.addAttribute("pname",pname);
	m.addAttribute("paddress", paddress);
	m.addAttribute("curlable", currencylable);
return new ModelAndView("supplierinvoiceview",model);
//return new ModelAndView("supplierinvoiceview");
}



@RequestMapping(value="saveinvoiceindb",method=RequestMethod.POST)
@ResponseBody
public void saveInvoiceData(@RequestBody String json,Model model) throws IOException{
	System.out.println(""+json);
	
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
	for(int i=0;i<meth.length;i=i+6){
		InvoiceTabBean tbean=new InvoiceTabBean();
		InvoiceDetailBean dbean=new InvoiceDetailBean();
		
		
		tbean.setInvdate(meth[i]);
		tbean.setInvno(meth[i+1]);
		tbean.setPorefno(meth[i+2]);
		dbean.setParticular(meth[i+3]);
		dbean.setTotalqty(Double.parseDouble(meth[i+4]));
		dbean.setReceiveqty(Double.parseDouble(meth[i+5]));
		if(i==0){
			prinicipalposervice.saveinvoicetab(tbean);
			prinicipalposervice.saveinvoicedetail(dbean,tbean);
			prinicipalposervice.saveproductstock(dbean,tbean);
		}else {
			prinicipalposervice.saveinvoicedetail(dbean,tbean);
			prinicipalposervice.saveproductstock(dbean,tbean);
		}
		
	}
	
	
}


}