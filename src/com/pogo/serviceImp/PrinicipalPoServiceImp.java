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
import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.PorefSupplierDetailBean;
import com.pogo.bean.ProductMasterBean;
import com.pogo.dao.PrinicipalDao;
import com.pogo.model.PoRefEntryItemDetail;
import com.pogo.model.PoRefEntryItemDetailCopy;
import com.pogo.model.PorefSupplierDetail;
import com.pogo.model.ProductMaster;
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
		pore.setPorefno(s2);
		porefentry.setParticular(poRefEntry.getParticular());
		porefentry.setProductdescription(poRefEntry.getProductdescription());
		porefentry.setTpinjpy(poRefEntry.getTpinjpy());
		porefentry.setQty(poRefEntry.getQty());
		porefentry.setTotaljpy(poRefEntry.getTotaljpy());
		porefentry.setCustomerporefe(poRefEntry.getCustomerporefe());
		porefentry.setPorefno(pore);
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
		porefsup.setPorefno(s2);
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


}
