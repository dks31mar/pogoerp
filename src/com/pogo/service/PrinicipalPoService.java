package com.pogo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.pogo.bean.ProductMasterBean;
import com.pogo.model.PoRefEntryItemDetailCopy;

public interface PrinicipalPoService {

	String getPartNo(ProductMasterBean productmasetr);

	String getproductDetail(ProductMasterBean productmasetr);

	void addPoProduct(PoRefEntryItemDetailCopy poRefEntry);

	List<PoRefEntryItemDetailCopy> proList(HttpServletRequest res);

	void deleteProduct(PoRefEntryItemDetailCopy prepareModel);

	public List<PoRefEntryItemDetailCopy> getProductEdit(int particular);

	void viewPo();

	Object getGrantTotal(HttpServletRequest res);
	
	
}