package com.pogo.service;

import java.util.List;

import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.ProductMasterBean;
import com.pogo.model.PoRefEntryItemDetail;
import com.pogo.model.PoRefEntryItemDetailCopy;

public interface PrinicipalPoService {

	String getPartNo(ProductMasterBean productmasetr);

	String getproductDetail(ProductMasterBean productmasetr);

	void addPoProduct(PoRefEntryItemDetailCopy poRefEntry);

	List<PoRefEntryItemDetailCopy> proList();

	void deleteProduct(PoRefEntryItemDetailCopy prepareModel);

	public List<PoRefEntryItemDetailCopy> getProductEdit(int particular);

	void viewPo();
	
	
}