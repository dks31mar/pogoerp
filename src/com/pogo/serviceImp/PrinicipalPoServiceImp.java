package com.pogo.serviceImp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.pogo.bean.InvoiceDetailBean;
import com.pogo.bean.InvoiceTabBean;
import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.PorefSupplierDetailBean;
import com.pogo.bean.ProductAcknowledgementBean;
import com.pogo.bean.ProductMasterBean;
import com.pogo.dao.PrinicipalDao;
import com.pogo.model.InvoiceDetail;
import com.pogo.model.InvoiceTab;
import com.pogo.model.PoRefEntryItemDetail;
import com.pogo.model.PoRefEntryItemDetailCopy;
import com.pogo.model.PorefSupplierDetail;
import com.pogo.model.ProductAcknowledgement;
import com.pogo.model.ProductMaster;
import com.pogo.model.ProductStock;
import com.pogo.service.PrinicipalPoService;

@Service("prinicipalposervice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PrinicipalPoServiceImp implements PrinicipalPoService{

	@Autowired
	private PrinicipalDao prinicipaldao;

	@Override
	public String getPartNo(ProductMasterBean productmasetr) {
		ProductMaster pm=new ProductMaster();
		pm.setProductname(productmasetr.getProductname());
		List<ProductMaster> partnoList=new ArrayList<ProductMaster>();
		partnoList=prinicipaldao.getPartNo(pm);
		JsonArray arry = new JsonArray(); 
		/*for(ProductMaster sub: partnoList)
		{
			JsonObject obj = new JsonObject();
			obj.addProperty("value",sub.getProductname());
			
			arry.add(obj);
			//productMap.put(sub.getOptiondescription(), sub.getFormname());
		}*/
		 System.out.println(arry);
		String json = new Gson().toJson(partnoList );
		System.out.println(" service method     \n"+json);
		return json;
	}

	@Override
	public String getproductDetail(ProductMasterBean productmasetr) {
		ProductMaster pm=new ProductMaster();
		pm.setProductname(productmasetr.getProductname());
		List<ProductMaster> partnoList=new ArrayList<ProductMaster>();
		partnoList=prinicipaldao.getproductDetail(pm);
		String json = new Gson().toJson(partnoList );
		System.out.println("((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((");
		return json;
	}

	@Override
	public void addPoProduct(PoRefEntryItemDetailBean poRefEntry,PorefSupplierDetailBean porefs) {
		
		String s=porefs.getPorefno();
		String s2=null;
		if(s.contains("CBW")){
			String data=s.split("/")[2];
			int i=Integer.parseInt(data.split("-")[1]);
			s2=s.split("/")[0]+"/"+s.split("/")[1]+"/"+"CBW"+"-"+(i+1);
		}else {
			int i=Integer.parseInt(s.split("/")[2]);
			s2=s.split("/")[0]+"/"+s.split("/")[1]+"/"+"0"+(i+1);
		}
		
		
		
		
		PoRefEntryItemDetail porefentry=new PoRefEntryItemDetail();
		PorefSupplierDetail pore=new PorefSupplierDetail();
		pore.setPorefno(s);
		porefentry.setParticular(poRefEntry.getParticular());
		porefentry.setProductdescription(poRefEntry.getProductdescription());
		porefentry.setTpinjpy(poRefEntry.getTpinjpy());
		porefentry.setQty(poRefEntry.getQty());
		porefentry.setTotaljpy(poRefEntry.getTotaljpy());
		porefentry.setCustomerporefe(poRefEntry.getCustomerporefe());
		porefentry.setPorefnobysupplier(pore);
		
		prinicipaldao.addPoDetails(porefentry);
		
	}

	@Override
	public List<PoRefEntryItemDetailCopy> proList(HttpServletRequest res) {
		List<PoRefEntryItemDetailCopy> list=prinicipaldao.proList();
		
		//prinicipaldao.getTotal(res);
		return list;
	}

	@Override
	public void deleteProduct(PoRefEntryItemDetailCopy prepareModel) {
		prinicipaldao.deleteProduct(prepareModel);
	}

	@Override
	public List<PoRefEntryItemDetailCopy> getProductEdit(int particular) {
		List<PoRefEntryItemDetailCopy> lsit=prinicipaldao.getProductEdit(particular);
		
		return lsit;
	}

	@Override
	public void viewPo() {
		prinicipaldao.savePo();
	}

	@Override
	public Object getGrantTotal(HttpServletRequest res) {
		
		return prinicipaldao.getGrantTotal(res);
	}

	@Override
	@Transactional
	public void addPoSupplier(PorefSupplierDetailBean porefs) {
		String s=porefs.getPorefno();
		String s2=null;
		if(s.contains("CBW")){
			String data=s.split("/")[2];
			int i=Integer.parseInt(data.split("-")[1]);
			s2=s.split("/")[0]+"/"+s.split("/")[1]+"/"+"CBW"+"-"+(i+1);
		}else {
			int i=Integer.parseInt(s.split("/")[2]);
			s2=s.split("/")[0]+"/"+s.split("/")[1]+"/"+"0"+(i+1);
		}
		
		PorefSupplierDetail porefsup=new PorefSupplierDetail();
		porefsup.setPorefno(s);
		porefsup.setAddress("Testing Private Limited,Bulding No.:XX ,XXXXX");
		porefsup.setPrincipalname("Testing Private Limited");
		porefsup.setPorefdate(porefs.getPorefdate());
		porefsup.setTotal(porefs.getTotal());
		prinicipaldao.addPoSupplier(porefsup);
		
	}

	@Override
	public List<PorefSupplierDetailBean> getSupplierlist() {
		List<PorefSupplierDetail> lst=prinicipaldao.getSupplierlist();
		List<PorefSupplierDetailBean> lst1=new ArrayList<>();
		for(PorefSupplierDetail e:lst){
			PorefSupplierDetailBean bean=new PorefSupplierDetailBean();
			bean.setAddress(e.getAddress());
			bean.setPorefdate(e.getPorefdate());
			bean.setPorefno(e.getPorefno());
			bean.setTotal(e.getTotal());
			bean.setPrincipalname(e.getPrincipalname());
			lst1.add(bean);
		}
		return lst1;
	}

	@Override
	public List<PoRefEntryItemDetailBean> getPoDetailByPorefNo(String poref) {
		List<PoRefEntryItemDetail> lst=prinicipaldao.getPoDetailByPorefNo(poref);
		System.out.println(lst);
		List<PoRefEntryItemDetailBean> lst1=new ArrayList<>();
		for(PoRefEntryItemDetail e:lst){
			PoRefEntryItemDetailBean bean=new PoRefEntryItemDetailBean();
			bean.setPorefentryitemdetailid(e.getPorefentryitemdetailid());
			  
		 	  bean.setParticular(e.getParticular());
		 	  bean.setTpinjpy(e.getTpinjpy());
		 	  bean.setQty(e.getQty());
		 	  bean.setTotaljpy(e.getTotaljpy());
		 	  bean.setTotalinr(e.getTotalinr());
		 	  bean.setAckdate(e.getAckdate());  
		 	  bean.setRemarks(e.getRemarks());
		 	  bean.setPosrno(e.getPosrno());
		 	  bean.setInvno(e.getInvno());
		 	  bean.setInvdate(e.getInvdate());
		 	  bean.setCustomerporefe(e.getCustomerporefe());
		 	  bean.setProductdescription(e.getProductdescription());
		 	  bean.setPorefnobysupplier(e.getPorefnobysupplier());
		 	  System.out.println(e.getParticular());
		 	
		 	 lst1.add(bean);
		}
		return lst1;
	}

	@Override
	@Transactional
	public void UpdatePoProduct(PoRefEntryItemDetailBean poref, PorefSupplierDetailBean porefs) {
		String s=porefs.getPorefno();
		
		
		String s2=null;
		if(s.contains("CBW")){
			String data=s.split("/")[2];
			int i=Integer.parseInt(data.split("-")[1]);
			s2=s.split("/")[0]+"/"+s.split("/")[1]+"/"+"CBW"+"-"+(i+1);
		}else {
			int i=Integer.parseInt(s.split("/")[2]);
			s2=s.split("/")[0]+"/"+s.split("/")[1]+"/"+"0"+(i+1);
		}
	
		
		
		PoRefEntryItemDetail porefentry=new PoRefEntryItemDetail();
		PorefSupplierDetail pore=new PorefSupplierDetail();
		porefentry.setPorefentryitemdetailid(poref.getPorefentryitemdetailid());
		pore.setPorefno(porefs.getPorefno());
		porefentry.setParticular(poref.getParticular());
		porefentry.setProductdescription(poref.getProductdescription());
		porefentry.setTpinjpy(poref.getTpinjpy());
		porefentry.setQty(poref.getQty());
		porefentry.setTotaljpy(poref.getTotaljpy());
		porefentry.setCustomerporefe(poref.getCustomerporefe());
		porefentry.setPorefnobysupplier(pore);
		
		prinicipaldao.addPoDetails(porefentry);
		
	}

	@Override
	@Transactional
	public void updatePoSupplier(PorefSupplierDetailBean porefs) {
		String s=porefs.getPorefno();
		String s2=null;
		if(s.contains("CBW")){
			String data=s.split("/")[2];
			int i=Integer.parseInt(data.split("-")[1]);
			s2=s.split("/")[0]+"/"+s.split("/")[1]+"/"+"CBW"+"-"+(i+1);
		}else {
			int i=Integer.parseInt(s.split("/")[2]);
			s2=s.split("/")[0]+"/"+s.split("/")[1]+"/"+"0"+(i+1);
		}
		PorefSupplierDetail porefgetid=prinicipaldao.getidbyporefnumber(s);
		PorefSupplierDetail porefsup=new PorefSupplierDetail();
		porefsup.setPorefsupplierdetailid(porefgetid.getPorefsupplierdetailid());
		porefsup.setPorefno(porefs.getPorefno());
		porefsup.setAddress("Testing Private Limited,Bulding No.:XX ,XXXXX");
		porefsup.setPrincipalname("Testing Private Limited");
		porefsup.setPorefdate(porefs.getPorefdate());
		porefsup.setTotal(porefs.getTotal());
		prinicipaldao.updatePoSupplier(porefsup);
	}

	@Override
	@Transactional
	public void deletePoById(String id) {
		int poid=Integer.parseInt(id);
		PoRefEntryItemDetail poref=new PoRefEntryItemDetail();
		poref.setPorefentryitemdetailid(poid);
		
		prinicipaldao.deletePoById(poref);
		
	}

	@Override
	@Transactional
	public List<PoRefEntryItemDetailBean> getPoDetailByPorefId(String poref) {
		List<PoRefEntryItemDetail> lst=prinicipaldao.getPoDetailByPorefId(poref);
		System.out.println(lst);
		List<PoRefEntryItemDetailBean> lst1=new ArrayList<>();
		for(PoRefEntryItemDetail e:lst){
			PoRefEntryItemDetailBean bean=new PoRefEntryItemDetailBean();
			bean.setPorefentryitemdetailid(e.getPorefentryitemdetailid());
			  
		 	  bean.setParticular(e.getParticular());
		 	  bean.setTpinjpy(e.getTpinjpy());
		 	  bean.setQty(e.getQty());
		 	  bean.setTotaljpy(e.getTotaljpy());
		 	  bean.setTotalinr(e.getTotalinr());
		 	  bean.setAckdate(e.getAckdate());  
		 	  bean.setRemarks(e.getRemarks());
		 	  bean.setPosrno(e.getPosrno());
		 	  bean.setInvno(e.getInvno());
		 	  bean.setInvdate(e.getInvdate());
		 	  bean.setCustomerporefe(e.getCustomerporefe());
		 	  bean.setProductdescription(e.getProductdescription());
		 	  bean.setPorefnobysupplier(e.getPorefnobysupplier());
		 	  System.out.println(e.getParticular());
		 	 System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>      "+e.getPorefnobysupplier().getPorefno());
		 	 lst1.add(bean);
		}
		return lst1;
	}

	@Override
	public List<PoRefEntryItemDetailBean> getackDetailByPorefNo(String poref) {
		List<PoRefEntryItemDetail> lst=prinicipaldao.getPoDetailByPorefNo(poref);
		System.out.println(lst);
		List<PoRefEntryItemDetailBean> lst1=new ArrayList<>();
		for(PoRefEntryItemDetail e:lst){
			PoRefEntryItemDetailBean bean=new PoRefEntryItemDetailBean();
			String porefNo=e.getPorefnobysupplier().getPorefno();
			String particular=e.getParticular();
			double pendingqty=e.getQty();
			double totolrecive=0.0;
			try{
			List<ProductAcknowledgement> proack=	prinicipaldao.getPendindQty(porefNo,particular);
			for(ProductAcknowledgement pro:proack){
				totolrecive+=pro.getReceiveqty();
				pendingqty=e.getQty()-totolrecive;
			}
			bean.setPendingqty(pendingqty);
			}catch(Exception ex){
				bean.setPendingqty(pendingqty);
				ex.printStackTrace();
				
			}
			
			  bean.setPorefentryitemdetailid(e.getPorefentryitemdetailid());
			  bean.setParticular(e.getParticular());
		 	  bean.setTpinjpy(e.getTpinjpy());
		 	  bean.setQty(e.getQty());
		 	  bean.setTotaljpy(e.getTotaljpy());
		 	  bean.setTotalinr(e.getTotalinr());
		 	  bean.setAckdate(e.getAckdate());  
		 	  bean.setRemarks(e.getRemarks());
		 	  bean.setPosrno(e.getPosrno());
		 	  bean.setInvno(e.getInvno());
		 	  bean.setInvdate(e.getInvdate());
		 	  
		 	  bean.setCustomerporefe(e.getCustomerporefe());
		 	  bean.setProductdescription(e.getProductdescription());
		 	  bean.setPorefnobysupplier(e.getPorefnobysupplier());
		 	  System.out.println(e.getParticular());
		 	  
		 	 lst1.add(bean);
		}
		return lst1;
	}

	@Override
	public void saveAcknowledData(ProductAcknowledgementBean bean) {
		ProductAcknowledgement proack=new ProductAcknowledgement();
		proack.setExpdate(bean.getExpdate());
		proack.setParticular(bean.getParticular());
		proack.setPendingqty(bean.getPendingqty()-bean.getReceiveqty());
		proack.setPorefno(bean.getPorefno());
		proack.setReceiveqty(bean.getReceiveqty());
		proack.setProductacknowledgementid(bean.getProductacknowledgementid());
		prinicipaldao.saveAcknowledData(proack);
		
	}

	@Override
	public List<ProductAcknowledgementBean> getAckData(String s1, String s2) {
		List<ProductAcknowledgement> productack=prinicipaldao.getAckData(s1,s2);
		List<ProductAcknowledgementBean> beanlist=new ArrayList<>();
		for(ProductAcknowledgement pa:productack){
			ProductAcknowledgementBean bean=new ProductAcknowledgementBean();
			bean.setExpdate(pa.getExpdate());
			bean.setParticular(pa.getParticular());
			bean.setPendingqty(pa.getPendingqty());
			bean.setPorefno(pa.getPorefno());
			bean.setReceiveqty(pa.getReceiveqty());
			bean.setProductacknowledgementid(pa.getProductacknowledgementid());
			beanlist.add(bean);
		}
		return beanlist;
	}

	@Override
	public void deleteParticularAck(String s1) {
		prinicipaldao.deleteParticularAck(s1);
		
	}

	@Override
	public List<PoRefEntryItemDetailBean> getInvoiceData(String poref) {
		List<PoRefEntryItemDetail> lst=prinicipaldao.getPoDetailByPorefNo(poref);
		System.out.println(lst);
		List<PoRefEntryItemDetailBean> lst1=new ArrayList<>();
		for(PoRefEntryItemDetail e:lst){
			PoRefEntryItemDetailBean bean=new PoRefEntryItemDetailBean();
			String porefNo=e.getPorefnobysupplier().getPorefno();
			String particular=e.getParticular();
			double pendingqty=e.getQty();
			double totolrecive=0.0;
			try{
			List<InvoiceDetail> proack=	prinicipaldao.getpendyqtyfrominvoice(porefNo,particular);
			for(InvoiceDetail pro:proack){
				totolrecive+=pro.getReceiveqty();
				pendingqty=e.getQty()-totolrecive;
			}
			bean.setPendingqty(pendingqty);
			}catch(Exception ex){
				bean.setPendingqty(pendingqty);
				ex.printStackTrace();
				
			}
			
			  bean.setPorefentryitemdetailid(e.getPorefentryitemdetailid());
			  bean.setParticular(e.getParticular());
		 	  bean.setTpinjpy(e.getTpinjpy());
		 	  bean.setQty(e.getQty());
		 	  bean.setTotaljpy(e.getTotaljpy());
		 	  bean.setTotalinr(e.getTotalinr());
		 	  bean.setAckdate(e.getAckdate());  
		 	  bean.setRemarks(e.getRemarks());
		 	  bean.setPosrno(e.getPosrno());
		 	  bean.setInvno(e.getInvno());
		 	  bean.setInvdate(e.getInvdate());
		 	  
		 	  bean.setCustomerporefe(e.getCustomerporefe());
		 	  bean.setProductdescription(e.getProductdescription());
		 	  bean.setPorefnobysupplier(e.getPorefnobysupplier());
		 	  System.out.println(e.getParticular());
		 	  
		 	 lst1.add(bean);
		}
		return lst1;
	}

	@Override
	@Transactional
	public void saveinvoicetab(InvoiceTabBean tbean) {
		InvoiceTab it=new InvoiceTab();
		it.setInvdate(tbean.getInvdate());
		it.setInvno(tbean.getInvno());
		it.setPorefno(tbean.getPorefno());
		prinicipaldao.saveinvoicetab(it);
	}

	@Override
	@Transactional
	public void saveinvoicedetail(InvoiceDetailBean dbean, InvoiceTabBean tbean) {
		InvoiceDetail id=new InvoiceDetail();
		InvoiceTab it=new InvoiceTab();
		it.setInvno(tbean.getInvno());
		
		
		
		
		id.setParticular(dbean.getParticular());
		id.setTotalqty(dbean.getTotalqty());
		id.setReceiveqty(dbean.getReceiveqty());
		id.setPorefno(tbean.getPorefno());
		
		
		id.setInvoicetab(it);
		
		prinicipaldao.saveinvoicedetail(id);
		
		
	}

	@Override
	@Transactional
	public void saveproductstock(InvoiceDetailBean dbean, InvoiceTabBean tbean) {
		int limit=(int)(dbean.getReceiveqty());
		Integer proId=prinicipaldao.getProidfrompromaster(dbean.getParticular());
		ProductStock prostock=null;
		for(int i=1;i<=limit;i++){
		prostock=new ProductStock();
		prostock.setProductname(dbean.getParticular());
		prostock.setProductid(proId);
		prostock.setInvno(tbean.getInvno());
		
			System.out.println(i+   "                               kkkkkkkkkkkkkkk          "+limit);
		prinicipaldao.saveproductstock(prostock);
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>     product iddddd    "+proId);
		
	}

	

	

}
