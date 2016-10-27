package com.pogo.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.ProductMasterBean;
import com.pogo.dao.PrinicipalDao;
import com.pogo.model.PoRefEntryItemDetail;
import com.pogo.model.PoRefEntryItemDetailCopy;
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
	public void addPoProduct(PoRefEntryItemDetailCopy poRefEntry) {
		prinicipaldao.addPoDetails(poRefEntry);
		
	}

	@Override
	public List<PoRefEntryItemDetailCopy> proList() {
		
		return prinicipaldao.proList();
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


}
